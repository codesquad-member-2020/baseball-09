//
//  NetworkManager.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class NetworkManager {
    
    public func requestData(url: String, completion: @escaping (_ data: Data?, _ error: Error?) -> ()) {
        guard let requestURL = URL(string: url) else { return }
        let request = URLRequest(url: requestURL)
        
        URLSession.shared.dataTask(with: request) { (data, res, error) in
            if let error = error { print(error); completion(nil, error) }
            
            completion(data, nil)
        }.resume()
    }
}
