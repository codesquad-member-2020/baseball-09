//
//  GameListReal.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/12.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct MainGameList: Codable {
    let success: Bool
    let response: [Game]
    let error: String?
}

struct Game: Codable {
    let id: Int
    let homeId: Int
    let awayId: Int
    let home: String
    let away: String
    let started: Bool
}
