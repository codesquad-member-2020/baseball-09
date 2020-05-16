//
//  LoginViewConrtoller.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/16.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit
import AuthenticationServices

class LoginViewConrtoller: UIViewController {
    
    private let dataUseCase = DataUseCase()
    private var session: ASWebAuthenticationSession?
    
    private let githubLoginUrl = "https://github.com/login/oauth/authorize/?client_id=4946b46078dcaa5adfa6&scope=user"
    private let schemeName = "baseball"
    private var isLoginSuccess = false
    
    private let nextViewSegue = "gameList"
    
    @IBOutlet weak var githubLoginButton: UIButton!
    @IBOutlet weak var gameStartButton: UIButton!
    
    @IBAction func githubLogin(_ sender: Any) {
        loginSession()
    }
    
    @IBAction func moveGameSelectView(_ sender: Any) {
        performSegue(withIdentifier: nextViewSegue, sender: self)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        changeButtonUi()
    }
    
    private func loginSession() {
        guard let authURL = URL(string: githubLoginUrl) else { return }
        let scheme = schemeName
        
        self.session = ASWebAuthenticationSession(url: authURL, callbackURLScheme: scheme)
        { callbackURL, error in
            guard error == nil, let callbackURL = callbackURL else { return }
            
            let queryItems = URLComponents(string: callbackURL.absoluteString)?.queryItems
            let token = queryItems?.filter({ $0.name == "token" }).first?.value
            TokenManager.tokenManager.jwtToken = token
            self.isLoginSuccess = true
            
            DispatchQueue.main.async {
                self.changeButtonUi()
            }
        }
        
        self.session?.presentationContextProvider = self
        self.session?.start()
    }
    
    private func changeButtonUi() {
        if isLoginSuccess {
            githubLoginButton.isHidden = true
            gameStartButton.isEnabled = true
            gameStartButton.isHidden = false
        } else {
            gameStartButton.isHidden = true
            gameStartButton.isEnabled = false
        }
    }
}

extension LoginViewConrtoller: ASWebAuthenticationPresentationContextProviding {
    func presentationAnchor(for session: ASWebAuthenticationSession) -> ASPresentationAnchor {
        return view.window!
    }
}
