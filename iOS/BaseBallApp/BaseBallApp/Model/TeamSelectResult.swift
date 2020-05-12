//
//  TeamSelectResult.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/12.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct TeamSelectResult: Codable {
    let success: Bool
    let response: Bool?
    let error: SelectError?
}

struct SelectError: Codable {
    let message: String
    let httpStatus: Int
}
