//
//  DataUseCase.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class DataUseCase {
    private let teamListEndPoint = "https://a2ce38a7-8dc6-4960-847e-fd40393fe743.mock.pstmn.io/games"
    
    func loadTeamList(manager: NetworkManager, completion: @escaping (GameList) -> ()) {
        manager.requestData(url: teamListEndPoint) { (data, error) in
            guard let data = data else { return }
            do {
                let json = try JSONDecoder().decode(GameList.self, from: data)
                completion(json)
            } catch {
                print(error)
            }
        }
    }
    
    
}
