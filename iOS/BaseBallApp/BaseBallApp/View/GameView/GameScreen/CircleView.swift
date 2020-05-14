//
//  CircleView.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/11.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class CircleView: UIView {

    override init(frame: CGRect) {
        super.init(frame: frame)
        setCircle()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setCircle()
    }
    
    private func setCircle() {
        self.layer.cornerRadius = self.frame.height / 2
        self.layer.borderColor = UIColor.darkGray.cgColor
        self.layer.borderWidth = 1
    }

}
