//
//  CurrentPitchLogViewModel.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/15.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class CurrentPitchLogViewModel {
    var logCount: Int = 0
    var pitchResult = [String]()
    var strikeBallCount = [String]()
    
    init(gameLog: GameTotalInfo) {
        self.logCount = gameLog.status.ball +
            gameLog.status.strike
        
        setPitchResult(gameLog: gameLog)
        countStrikeBallCount(gameLog: gameLog)
    }
    
    private func countStrikeBallCount(gameLog: GameTotalInfo) {
        if logCount == 0 { return }
        
        for _ in 0...logCount {
            var ballCount = 0
            var strikeCount = 0
            for index in gameLog.log.count - logCount ... gameLog.log.count - 1 {
                if gameLog.log[index].status == "BALL" {
                    ballCount += 1
                } else if gameLog.log[index].status == "STRIKE" {
                    strikeCount += 1
                }
            }
            self.strikeBallCount.append("\(strikeCount)-\(ballCount)")
        }
    }
    
    private func setPitchResult(gameLog: GameTotalInfo) {
        if logCount == 0 { pitchResult = [String](); return }
        
        for index in gameLog.log.count - logCount ... gameLog.log.count-1 {
            self.pitchResult.append(gameLog.log[index].status)
        }
    }
}
