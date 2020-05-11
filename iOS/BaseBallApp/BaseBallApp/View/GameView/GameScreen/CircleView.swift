//
//  CircleView.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class CircleView: UIView {
    private(set) var fillColor: UIColor = .clear

    override func draw(_ rect: CGRect) {
        UIColor.darkGray.setStroke()
        fillColor.setFill()
        
        let circlePath = UIBezierPath(ovalIn: rect)
        circlePath.stroke()
        circlePath.fill()
    }
}
