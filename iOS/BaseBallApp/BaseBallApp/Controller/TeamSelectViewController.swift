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
    
    public var awayTeamId: Int?
    public var homeTeamId: Int?
    private var selectId: Int!
    public var gameId: Int?
    
    private let dataUseCase = DataUseCase()
    private var teamSelectAlert: UIAlertController!
    
    @IBAction func selectAwayTeam(_ sender: Any) {
        requestSelectTeam(selectTeamId: awayTeamId!)
    }
    @IBAction func selectHomeTeam(_ sender: Any) {
        requestSelectTeam(selectTeamId: homeTeamId!)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setModalUI()
        setAlertController()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let nextView = segue.destination as? GameTabController else { return }
        guard let gameView = nextView.viewControllers?.first as? GameViewController else { return }
        
        gameView.gameId = gameId
        
        if selectId % 2 == 0 {
            gameView.isAttackInning = true
        } else {
            gameView.isAttackInning = false
        }
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
    
    private func requestSelectTeam(selectTeamId: Int) {
        selectId = selectTeamId
        dataUseCase.isTeamSelect(manager: NetworkManager(), selectTeamId: selectTeamId) { (result) in
            if result {
                self.dataUseCase.postGameStart(manager: NetworkManager(), gameId: self.gameId!)
                self.performSegue(withIdentifier: "gameScreen", sender: self)
            } else {
                self.present(self.teamSelectAlert, animated: true, completion: nil)
            }
        }
    }
}
