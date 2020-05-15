//
//  CurrentBatterInfo.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/15.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct CurrentBatterInfo: Codable {
    let gameId: Int
    let teamId: Int
    let playerId: Int
    let inning: Int
    let battingAverage: Int
    let isBottom: Bool
}
