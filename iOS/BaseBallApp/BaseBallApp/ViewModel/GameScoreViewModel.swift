//
//  GameScoreViewModel.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/11.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class GameScoreViewModel {
    let awayTeam: String
    let homeTeam: String
    let awayScore: String
    let homeScore: String
    
    init(gameInfo: GameTotalInfo) {
        self.awayTeam = gameInfo.awayName
        self.homeTeam = gameInfo.homeName
        self.awayScore = String(gameInfo.awayScore)
        self.homeScore = String(gameInfo.homeScore)
    }
}
