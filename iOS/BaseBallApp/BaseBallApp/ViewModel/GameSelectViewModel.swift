//
//  File.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class GameSelectViewModel {
    let gameList: [Game]
    
    init(gameList: MainGameList) {
        self.gameList = gameList.response
    }
}
