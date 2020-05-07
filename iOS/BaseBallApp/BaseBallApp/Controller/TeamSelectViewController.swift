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
    
    @IBAction func selectAwayTeam(_ sender: Any) {
        
    }
    @IBAction func selectHomeTeam(_ sender: Any) {
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setUI()
    }
    
    private func setUI() {
        awayTeamButton.setTitle(awayTeamButtonTitle, for: .normal)
        homeTeamButton.setTitle(homeTeamButtonTitle, for: .normal)
        
        teamSelectModal.layer.cornerRadius = 20
        
        let blurEffect = UIBlurEffect(style: .dark)
        let blurEffectView = UIVisualEffectView(effect: blurEffect)
        blurEffectView.frame = self.view.frame

        self.view.insertSubview(blurEffectView, at: 0)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
