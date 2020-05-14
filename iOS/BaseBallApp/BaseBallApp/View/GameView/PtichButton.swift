//
//  PtichButton.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/14.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class PtichButton: UIButton {

    override init(frame: CGRect) {
        super.init(frame: frame)
        roundBorder()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        roundBorder()
    }
    
    private func roundBorder() {
        self.layer.cornerRadius = 20
    }

}
