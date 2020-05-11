//
//  File.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class GameSelectViewModel {
    let gameList: GameList
    var homeTeamList = [String]()
    var awayTeamList = [String]()
    
    init(gameList: GameList) {
        self.gameList = gameList
        
        gameList.games.forEach { (teamList) in
            self.awayTeamList.append(teamList.away_team.name)
            self.homeTeamList.append(teamList.home_team.name)
        }
    }
}
