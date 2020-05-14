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
    private var scoreViewModel: GameScoreViewModel!
    private var infoViewModel: GameInfoViewModel!
    private var currentPlayerViewModel: CurrentPlayerViewModel!
    
    public var gameId: Int!
    public var isAttackInning: Bool!
    public var homeTeamName: String!
    public var awayTeamName: String!
    
    private var isGameProgress = true
    private var pitchLog = [String]()
    
    @IBAction func pitchingButton(_ sender: Any) {
        dataUseCase.pitchingAction(manager: NetworkManager()) { (result) in
            self.pitchLog.append(result)
        }
        updateUIWithRequest()
        
        self.pitchingButtonLabel.isUserInteractionEnabled = false
        Timer.scheduledTimer(withTimeInterval: 10, repeats: false) { _ in
            self.pitchingButtonLabel.isUserInteractionEnabled = true
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        gameControl()
    }
    
    private func gameControl() {
        while isGameProgress {
            if isAttackInning {
                pitchingButtonLabel.isHidden = true
                updateUIWithRequest()
                sleep(10)
            } else {
                pitchingButtonLabel.isHidden = false
            }
        }
    }
    
    private func updateUIWithRequest() {
        dataUseCase.requestGameProgress(manager: NetworkManager(), gameId: gameId) { (gameInfo) in
            self.scoreViewModel = GameScoreViewModel(gameInfo: gameInfo)
            self.infoViewModel = GameInfoViewModel(gameInfo: gameInfo)
            self.currentPlayerViewModel = CurrentPlayerViewModel(batterBoxInfo: gameInfo.game)
            
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
        
        gameProgressView.gameProgress.text = infoViewModel.inningInfo
        gameProgressView.gameRotate.text = isAttackInning ? "수비" : "공격"
    }
    
    private func setGameInfo() {
        setStrikeInfo(count: infoViewModel.strikeCount)
        setBallInfo(count: infoViewModel.ballCount)
        setOutInfo(count: infoViewModel.outCount)
    }
    
    private func setGameScore() {
        gameScoreView.awayTeamName.text = awayTeamName
        gameScoreView.homeTeamName.text = homeTeamName
        gameScoreView.awayTeamScore.text = scoreViewModel.awayScore
        gameScoreView.homeTeamScore.text = scoreViewModel.homeScore
    }
    
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
    
    private func setCurrentPlayer() {
        currentPlayerView.batter.text = currentPlayerViewModel.batterName
        currentPlayerView.pitcher.text = currentPlayerViewModel.pitcherName
    }
}
