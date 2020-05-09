//
//  CurrentPlayerCell.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class CurrentPlayerCell: UITableViewCell {
    @IBOutlet weak var playerType: UILabel!
    @IBOutlet weak var playerName: UILabel!
    @IBOutlet weak var playerInfo: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }

}
