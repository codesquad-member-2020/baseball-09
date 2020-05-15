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
    @IBOutlet weak var currentPlayerView: CurrentPlayerView!
    @IBOutlet weak var currentPlayLog: UITableView!
    @IBOutlet weak var pitchingButtonLabel: PtichButton!
    
    private let dataUseCase = DataUseCase()
    private let dataSource = GameTableViewDataSource()
    private var scoreViewModel: GameScoreViewModel!
    private var infoViewModel: GameInfoViewModel!
    private var currentPlayerViewModel: CurrentPlayerViewModel!
    private var currentPitchLog: CurrentPitchLogViewModel!
    
    public var gameId: Int!
    public var isAttackInning: Bool!
    
    private var isGameProgress = true
    private var pitchLog = [String]()
    private var batterInfo: CurrentBatterInfo!
    
    @IBAction func pitchingButton(_ sender: Any) {
        dataUseCase.pitchingAction(manager: NetworkManager(), batterInfo: batterInfo) { (result) in
            self.pitchLog.append(result)
        }
        updateUIWithRequest()
        
        self.pitchingButtonLabel.isUserInteractionEnabled = false
        Timer.scheduledTimer(withTimeInterval: 5, repeats: false) { _ in
            self.pitchingButtonLabel.isUserInteractionEnabled = true
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        currentPlayLog.dataSource = dataSource
        
        DispatchQueue.global().async {
            self.updateUIWithRequest()
            self.gameControl()
        }
    }
    
    private func gameControl() {
        while isGameProgress {
            if isAttackInning {
                pitchingButtonLabel.isHidden = true
                updateUIWithRequest()
                sleep(5)
            } else {
                pitchingButtonLabel.isHidden = false
            }
        }
    }
    
    private func updateUIWithRequest() {
        dataUseCase.requestGameProgress(manager: NetworkManager(), gameId: gameId) {
            (gameInfo) in
            print(gameInfo)
            self.scoreViewModel = GameScoreViewModel(gameInfo: gameInfo)
            self.infoViewModel = GameInfoViewModel(gameInfo: gameInfo)
            self.currentPlayerViewModel = CurrentPlayerViewModel(batterBoxInfo: gameInfo.game)
            self.currentPitchLog = CurrentPitchLogViewModel(gameLog: gameInfo)
            
            if gameInfo.game.away.pitcher {
                self.batterInfo = CurrentBatterInfo(gameId: gameInfo.gameId, teamId: gameInfo.game.home.teamId, playerId: gameInfo.game.home.id, inning: gameInfo.inning, battingAverage: gameInfo.game.home.battingAverage, isBottom: gameInfo.bottom)
            } else {
                self.batterInfo = CurrentBatterInfo(gameId: gameInfo.gameId, teamId: gameInfo.game.away.teamId, playerId: gameInfo.game.away.id, inning: gameInfo.inning, battingAverage: gameInfo.game.away.battingAverage, isBottom: gameInfo.bottom)
            }
            
            DispatchQueue.main.async {
                self.setUI()
            }
            
            if gameInfo.bottom {
                self.isAttackInning = !self.isAttackInning
                self.pitchLog.removeAll()
            }
            
            if gameInfo.inning == 10 {
                self.isGameProgress = false
            }
        }
    }
    
    private func setUI() {
        setGameScore()
        setGameInfo()
        setCurrentPlayer()
        
        dataSource.logViewModel = currentPitchLog
        
        gameProgressView.gameProgress.text = infoViewModel.inningInfo
        gameProgressView.gameRotate.text = isAttackInning ? "공격" : "수비"
        
        currentPlayLog.reloadData()
    }
    
    private func setGameInfo() {
        setStrikeInfo(count: infoViewModel.strikeCount)
        setBallInfo(count: infoViewModel.ballCount)
        setOutInfo(count: infoViewModel.outCount)
    }
    
    private func setGameScore() {
        gameScoreView.awayTeamName.text = scoreViewModel.awayTeam
        gameScoreView.homeTeamName.text = scoreViewModel.homeTeam
        gameScoreView.awayTeamScore.text = scoreViewModel.awayScore
        gameScoreView.homeTeamScore.text = scoreViewModel.homeScore
    }
    
    private func setStrikeInfo(count: Int) {
        if count == 0 {
            for index in 1...2 {
                gameScreenView.strikeInfo.arrangedSubviews[index].backgroundColor = .white
            }
            return
        }
        
        for index in 1...count {
            gameScreenView.strikeInfo.arrangedSubviews[index].backgroundColor = .yellow
        }
    }
    
    private func setBallInfo(count: Int) {
        if count == 0 {
            for index in 1...3 {
                gameScreenView.ballInfo.arrangedSubviews[index].backgroundColor = .white
            }
            return
        }
        
        for index in 1...count {
            gameScreenView.ballInfo.arrangedSubviews[index].backgroundColor = .green
        }
    }
    
    private func setOutInfo(count: Int) {
        if count == 0 {
            for index in 1...2 {
                gameScreenView.outInfo.arrangedSubviews[index].backgroundColor = .white
            }
            return
        }
        
        for index in 1...count {
            gameScreenView.outInfo.arrangedSubviews[index].backgroundColor = .red
        }
    }
    
    private func setCurrentPlayer() {
        currentPlayerView.batter.text = currentPlayerViewModel.batterName
        currentPlayerView.pitcher.text = currentPlayerViewModel.pitcherName
    }
}
