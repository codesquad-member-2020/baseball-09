//
//  GameViewController.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameViewController: UIViewController {
    @IBOutlet weak var gameScoreView: TeamScoreView!
    @IBOutlet weak var GameScreenView: UIView!
    @IBOutlet weak var CurrentPlayerView: UITableView!
    @IBOutlet weak var GameLogView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
}
