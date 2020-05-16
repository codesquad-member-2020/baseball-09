//
//  NetworkManager.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/10.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class NetworkManager {
    
    public func requestData(url: String, method: URLRequest.HTTPMethod, contentType: String?, body: Data?, completion: @escaping (_ data: Data?, _ response: URLResponse?, _ error: Error?) -> ()) {
        guard let requestURL = URL(string: url) else { return }
        let request = URLRequest(url: requestURL, method: method, contentType: contentType, body: body)
    
        URLSession.shared.dataTask(with: request) { (data, res, error) in
            if let error = error { print(error); completion(nil, nil, error) }
            
            completion(data, res, nil)
        }.resume()
    }
}


extension URLRequest {
    public enum HTTPMethod: String {
        case get = "GET"
        case put = "PUT"
        case post = "POST"
        case delete = "DELETE"
    }
    
    public var method: HTTPMethod? {
        get {
            guard let httpMethod = self.httpMethod else { return nil }
            let method = HTTPMethod(rawValue: httpMethod)
            return method
        } set {
            self.httpMethod = newValue?.rawValue
        }
    }
}

extension URLRequest {
    public init(url: URL, method: HTTPMethod, contentType: String?, body: Data?) {
        self.init(url: url)
        self.method = method
        self.setValue(contentType, forHTTPHeaderField: "Content-Type")
        self.httpBody = body
    }
}
