//
//  postGameStart.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/15.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct PostGameStart: Codable {
    let success: Bool
    let response: PostGameStartResponse
    let error: String?
}

struct PostGameStartResponse: Codable {
    let id: Int
    let matchId: Int
}
