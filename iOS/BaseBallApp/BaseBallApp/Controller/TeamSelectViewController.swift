//
//  SelectTeamViewController.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/07.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class TeamSelectViewController: UIViewController {
    @IBOutlet weak var teamSelectModal: UIView!
    
    @IBOutlet weak var awayTeamButton: TeamSelectButton!
    @IBOutlet weak var homeTeamButton: TeamSelectButton!
    public var awayTeamButtonTitle: String?
    public var homeTeamButtonTitle: String?
    
    private var teamSelectAlert: UIAlertController!
    @IBAction func selectAwayTeam(_ sender: Any) {
        performSegue(withIdentifier: "gameScreen", sender: self)
    }
    @IBAction func selectHomeTeam(_ sender: Any) {
        present(teamSelectAlert, animated: true, completion: nil)
        //performSegue(withIdentifier: "gameScreen", sender: self)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setModalUI()
        setAlertController()
    }
    
    private func setModalUI() {
        awayTeamButton.setTitle(awayTeamButtonTitle, for: .normal)
        homeTeamButton.setTitle(homeTeamButtonTitle, for: .normal)
        
        teamSelectModal.layer.cornerRadius = 20
        
        let blurEffect = UIBlurEffect(style: .dark)
        let blurEffectView = UIVisualEffectView(effect: blurEffect)
        blurEffectView.frame = self.view.frame
        
        self.view.insertSubview(blurEffectView, at: 0)
    }
    
    private func setAlertController() {
        teamSelectAlert = UIAlertController(title: "팀 선택 불가", message: "이미 선점된 팀입니다.", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        teamSelectAlert.addAction(okAction)
    }
}
