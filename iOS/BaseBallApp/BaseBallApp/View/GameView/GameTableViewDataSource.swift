//
//  GameTableViewDataSource.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/15.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameTableViewDataSource: NSObject, UITableViewDataSource {
    private let cellIdentifier = "GameLog"
    public var logViewModel: CurrentPitchLogViewModel?
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return logViewModel?.logCount ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath) as? GameLogCell else { return UITableViewCell() }
        
        cell.pitchCount.text = String(indexPath.row + 1)
        print(indexPath.row)
        cell.pitchResult.text = logViewModel?.pitchResult[indexPath.row]
        cell.strikeBallCount.text = logViewModel?.strikeBallCount[indexPath.row]
 
        return cell
    }
    
    
}
