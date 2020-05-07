//
//  GameSelectView.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/07.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameSelectView: UITableViewCell {
    @IBOutlet weak var GameCountLabel: UILabel!
    @IBOutlet weak var AwayTeamLabel: UILabel!
    @IBOutlet weak var HomeTeamLabel: UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        setNibView()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    private func setNibView() {
        self.contentView.layer.cornerRadius = 20
        self.selectionStyle = .none
    }
}
