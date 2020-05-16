//
//  token.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/16.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class TokenManager {
    static let tokenManager = TokenManager()
    var jwtToken: String?
    private init() {}

    func getJwtToken() -> String {
        return self.jwtToken!
    }
}
