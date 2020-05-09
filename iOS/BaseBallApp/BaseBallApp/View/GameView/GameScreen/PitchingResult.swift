//
//  PitchingResult.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class PitchingResult: UIView {
    @IBOutlet weak var pitchingResultType: UILabel!
    @IBOutlet weak var circleStackView: UIStackView!
    @IBOutlet weak var circleView: CircleView!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    private func addCircleInStackView() {
        circleStackView.addArrangedSubview(circleView)
    }
}
