//
//  TeamSelectButton.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/07.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class TeamSelectButton: UIButton {
    override init(frame: CGRect) {
        super.init(frame: frame)
        setButtonBorder()
        setButtonShadow()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setButtonBorder()
        setButtonShadow()
    }
    
    private func setButtonBorder() {
        self.layer.borderColor = UIColor.darkGray.cgColor
        self.layer.borderWidth = 2
        self.layer.cornerRadius = 15
    }
    
    private func setButtonShadow() {
        self.backgroundColor = UIColor(named: "ButtonColor")
        self.layer.shadowColor = UIColor(red: 0, green: 0, blue: 0, alpha: 0.25).cgColor
        self.layer.shadowOffset = CGSize(width: 0.0, height: 3.0)
        self.layer.shadowOpacity = 1.0
        self.layer.shadowRadius = 0.0
        self.layer.masksToBounds = false
    }
}
