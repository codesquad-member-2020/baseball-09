//
//  PitchingResult.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/14.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct PitchingResult: Codable {
    let success: Bool
    let response: String
    let error: String?
}
