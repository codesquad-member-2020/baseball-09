//
//  GameLogCell.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameLogCell: UITableViewCell {
    @IBOutlet weak var pitchCount: UILabel!
    @IBOutlet weak var pitchResult: UILabel!
    @IBOutlet weak var strikeBallCount: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }

}
