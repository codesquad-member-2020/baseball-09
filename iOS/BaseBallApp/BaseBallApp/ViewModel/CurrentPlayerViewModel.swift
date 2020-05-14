//
//  File.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/11.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class CurrentPlayerViewModel {
    var batterName: String?
    var pitcherName: String?
    
    init(batterBoxInfo: BatterBox) {
        if batterBoxInfo.away.pitcher {
            pitcherName = batterBoxInfo.away.name
            batterName = batterBoxInfo.home.name
        } else {
            pitcherName = batterBoxInfo.home.name
            batterName = batterBoxInfo.away.name
        }
    }
}
