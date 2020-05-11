//
//  File.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct GameList: Codable {
    let games: [TeamList]
}

struct TeamList: Codable {
    let id: Int
    let home_team: TeamInfo
    let away_team: TeamInfo
}

struct TeamInfo: Codable {
    let id: Int
    let name: String
}


