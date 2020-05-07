//
//  DataManager.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/06.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

final class DataManager {
    private var teamList: [[String]]? = [["Captin", "Marvel"], ["Twins", "Tigers"], ["Rockets", "Dodgers"], ["Heros", "Pintos"]]
    
    public func setTeamList(team: [[String]]) {
        self.teamList = team
    }
    
    public func getTeamList() -> [[String]]? {
        return teamList
    }
}
