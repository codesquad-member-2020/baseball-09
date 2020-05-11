//
//  ViewController.swift
//  AnimationTest
//
//  Created by 임승혁 on 2020/05/11.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    private var layer1: CALayer!
    private var layer2: CALayer!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        layer1 = CALayer()
        layer1.frame = CGRect(x: 30, y: 30, width: 50, height: 50)
        layer1.backgroundColor = UIColor.red.cgColor
        view.layer.addSublayer(layer1)
        
        layer2 = CALayer()
        layer2.frame = CGRect(x: 30, y: 100, width: 50, height: 50)
        layer2.backgroundColor = UIColor.blue.cgColor
        view.layer.addSublayer(layer2)
        
        
        let boundingRect = CGRect(x: 50, y: 50, width: 300, height: 300)
        
        let orbit = CAKeyframeAnimation(keyPath: "position")
        orbit.path = CGPath(ellipseIn: boundingRect, transform: nil)
        orbit.duration = 2
        orbit.isAdditive = true
        orbit.repeatCount = HUGE
        orbit.calculationMode = .discrete
        orbit.rotationMode = .rotateAuto
        
        layer1.add(orbit, forKey: "orbit")
        
    }
    
    @IBAction func buttonOne() {
        let animation = CABasicAnimation.init(keyPath: "position.x")
        animation.fromValue = 30
        animation.toValue = 455
        animation.duration = 1
        
        layer1.add(animation, forKey:"basic")
        layer1.position = CGPoint(x: 455, y: 30)
    }
    
    @IBAction func buttonTwo() {
        let animation = CABasicAnimation.init(keyPath: "position.x")
        animation.byValue = 378
        animation.duration = 1
        
        layer2.position = CGPoint(x: 455, y: 100)
        
        animation.beginTime = CACurrentMediaTime() + 0.5
        layer2.position = CGPoint(x: 455, y: 111)
    }
    
    @IBAction func buttonThree() {
        let animation = CAKeyframeAnimation(keyPath: "position.x")
        animation.values = [0, 10, -10, 10, 0]
        animation.keyTimes = [NSNumber(value: 0),
                              NSNumber(value: 1.0/6.0),
                              NSNumber(value: 3.0/6.0),
                              NSNumber(value: 5.0/6.0),
        NSNumber(value: 1)]
        
        animation.duration = 0.4
        animation.isAdditive = true
        layer1.add(animation, forKey: "shake")
        
    }


}

