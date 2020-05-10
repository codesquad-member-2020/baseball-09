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
    @IBOutlet weak var gameScreenView: UIView!
    @IBOutlet weak var currentPlayer: UITableView!
    @IBOutlet weak var currentPlayLog: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
