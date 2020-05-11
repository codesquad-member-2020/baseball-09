//
//  GameScreenView.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/09.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameScreenView: UIView {
    
    override func draw(_ rect: CGRect) {
        drawBaseBallLine(origin: rect.width, shrink: 0.5)
        self.transform = CGAffineTransform(rotationAngle: 45 / 180.0 * .pi)
    }
    
    private func drawBaseBallLine(origin rectSide: CGFloat, shrink ratio: CGFloat) {
        let lineSide = rectSide * ratio
        let startPoint = CGPoint(x: (rectSide - lineSide) / 2, y: (rectSide - lineSide) / 2)
        var pathLog = [CGPoint]()
        
        UIColor.darkGray.setStroke()
        
        let path = UIBezierPath()
        path.lineWidth = 5
        
        path.move(to: CGPoint(x: startPoint.x, y: startPoint.y))
        pathLog.append(path.currentPoint)
        
        path.addLine(to: CGPoint(x: startPoint.x, y: startPoint.y+lineSide))
        pathLog.append(path.currentPoint)
        
        path.addLine(to: CGPoint(x: startPoint.x+lineSide, y: startPoint.y+lineSide))
        
        path.addLine(to: CGPoint(x: startPoint.x+lineSide, y: startPoint.y))
        pathLog.append(path.currentPoint)
        
        path.close()
        path.stroke()
        
        pathLog.forEach {
            drawFootHold(startPoint: $0)
        }
        
        drawHomeFootHold(startPoint: CGPoint(x: startPoint.x + lineSide, y: startPoint.y + lineSide))
    }
    
    private func drawFootHold(startPoint: CGPoint) {
        let footHoldSize:CGFloat = 20
        
        UIColor.gray.setStroke()
        UIColor.white.setFill()
        
        let path = UIBezierPath(rect: CGRect(origin: CGPoint(x: startPoint.x - footHoldSize/2,
                                                             y: startPoint.y - footHoldSize/2),
                                             size: CGSize(width: footHoldSize, height: footHoldSize)))
        path.lineWidth = 1
        path.stroke()
        path.fill()
    }
    
    private func drawHomeFootHold(startPoint: CGPoint) {
        let footHoldSize:CGFloat = 30
        let footHoldSqrtSize:CGFloat = (CGFloat(2.0.squareRoot()) * footHoldSize/2)
        
        UIColor.white.set()
        
        let movePoint = CGPoint(x: startPoint.x - footHoldSize/2, y: startPoint.y)
        
        let path = UIBezierPath()
        path.move(to: movePoint)
        path.addLine(to: CGPoint(x: movePoint.x, y: movePoint.y + footHoldSize))
        path.addLine(to: CGPoint(x: movePoint.x + footHoldSize, y: movePoint.y + footHoldSize))
        path.addLine(to: CGPoint(x: movePoint.x + footHoldSize, y: movePoint.y))
        path.addLine(to: CGPoint(x: startPoint.x,
                                 y: path.currentPoint.y - footHoldSqrtSize))
        
        path.rotate(centerPoint: startPoint, degree: -45)
        path.fill()
    }
    
}

extension UIBezierPath {
    func rotate(centerPoint: CGPoint, degree: CGFloat) {
        let radians = (degree / 180.0 * .pi)
        
        self.apply(CGAffineTransform(translationX: -centerPoint.x, y: -centerPoint.y))
        self.apply(CGAffineTransform(rotationAngle: radians))
        self.apply(CGAffineTransform(translationX: centerPoint.x, y: centerPoint.y))
    }
}
