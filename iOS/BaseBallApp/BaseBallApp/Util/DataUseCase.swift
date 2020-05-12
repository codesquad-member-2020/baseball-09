//
//  DataUseCase.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class DataUseCase {
    private let basicEndPoint = "http://18.213.230.151/api/"
    private let gameList = "main"
    
    
    func loadTeamList(manager: NetworkManager, completion: @escaping (MainGameList) -> ()) {
        manager.requestData(url: basicEndPoint + gameList) { (data, error) in
            guard let data = data else { return }
            do {
                let json = try JSONDecoder().decode(MainGameList.self, from: data)
                completion(json)
            } catch {
                print(error)
            }
        }
    }
    
    
}
