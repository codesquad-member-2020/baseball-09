//
//  GameViewController.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameViewController: UIViewController {
    @IBOutlet weak var gameScoreView: TeamScoreView!
    @IBOutlet weak var gameScreenView: GameScreenTotalView!
    @IBOutlet weak var gameProgressView: GameProgressView!
    
    @IBOutlet weak var currentPlayLog: UITableView!
    
    private let dataUseCase = DataUseCase()
    private var scoreViewModel: GameScoreViewModel!
    private var infoViewModel: GameInfoViewModel!
    
    public var gameId: Int?
    public var selectTeamId: Int?
    public var homeTeamName: String?
    public var awayTeamName: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        while true {
            dataUseCase.requestGameProgress(manager: NetworkManager(), gameId: gameId!) { (gameInfo) in
                self.scoreViewModel = GameScoreViewModel(gameInfo: gameInfo)
                self.infoViewModel = GameInfoViewModel(gameInfo: gameInfo)
                DispatchQueue.main.async {
                    self.setUI()
                }
                
                if gameInfo.inning == 13 {
                    return
                }
            }
            sleep(10)
        }
    }
    
    private func setUI() {
        setGameScore()
        setGameInfo()
        
        gameProgressView.gameProgress.text = infoViewModel.inningInfo
        gameProgressView.gameRotate.text = (selectTeamId! % 2 == infoViewModel.inning % 2) ? "수비" : "공격"
    }
    
    private func setGameInfo() {
        setStrikeInfo(count: infoViewModel.strikeCount)
        setBallInfo(count: infoViewModel.ballCount)
        setOutInfo(count: infoViewModel.outCount)
    }
    
    // 상단 게임 스코어
    private func setGameScore() {
        gameScoreView.awayTeamName.text = awayTeamName
        gameScoreView.homeTeamName.text = homeTeamName
        gameScoreView.awayTeamScore.text = scoreViewModel.awayScore
        gameScoreView.homeTeamScore.text = scoreViewModel.homeScore
    }
    
    // SBO 상태
    private func setStrikeInfo(count: Int) {
        for index in 1...count {
            gameScreenView.strikeInfo.arrangedSubviews[index].backgroundColor = .yellow
        }
    }
    
    private func setBallInfo(count: Int) {
        for index in 1...count {
            gameScreenView.ballInfo.arrangedSubviews[index].backgroundColor = .green
        }
    }
    
    private func setOutInfo(count: Int) {
        for index in 1...count {
            gameScreenView.outInfo.arrangedSubviews[index].backgroundColor = .red
        }
    }
}
