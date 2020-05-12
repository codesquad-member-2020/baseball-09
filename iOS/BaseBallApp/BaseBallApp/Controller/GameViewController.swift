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
    @IBOutlet weak var currentPlayer: UITableView!
    @IBOutlet weak var currentPlayLog: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setGameScore()
        setGameInfo()
    }
    
    private func setGameInfo() {
        setStrikeInfo(count: 1)
        setBallInfo(count: 2)
        setOutInfo(count: 1)
    }
    
    // 상단 게임 스코어
    private func setGameScore() {
        /*
        gameScoreView.awayTeamName.text
        gameScoreView.homeTeamName.text
        gameScoreView.awayTeamScore.text
        gameScoreView.homeTeamScore.text
         */
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
