//
//  GameProgressInfo.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/13.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct GameProgressInfo: Codable {
    let success: Bool
    let response: GameTotalInfo
    let error: Bool?
}

struct GameTotalInfo: Codable {
    let gameId: Int
    let inning: Int
    let homeName: String
    let homeScore: Int
    let awayName: String
    let awayScore: Int
    let game: BatterBox
    let status: PitchStatus
    let log: [BatterLog]
    let bottom: Bool
    
}

struct PitchStatus: Codable {
    let gameId: Int
    let inning: Int
    let strike: Int
    let ball: Int
    let out: Int
    let hit: Int
}

struct BatterBox: Codable {
    let home: BatterInfo
    let away: BatterInfo
}


struct BatterInfo: Codable {
    let id: Int
    let teamId: Int
    let name: String
    let battingAverage: Int
    let pitcher: Bool
}

struct BatterLog: Codable {
    let id: Int
    let gameId: Int
    let playerId: Int
    let inning: Int
    let status: String
}
