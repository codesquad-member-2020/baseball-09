//
//  ViewController.swift
//  BaseBallApp
//
//  Created by 임승혁 on 2020/05/05.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class GameSelectViewController: UIViewController {
    @IBOutlet weak var GameListTableView: UITableView!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        GameListTableView.delegate = self
        GameListTableView.dataSource = self
        
        registGameListTableViewCell()
    }
    
    private func registGameListTableViewCell() {
        let cellNib = UINib(nibName: "GameSelectView", bundle: nil)
        GameListTableView.register(cellNib, forCellReuseIdentifier: "GameSelectCell")
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let teamSelectView = segue.destination as? TeamSelectViewController else { return }
        guard let selectedCell = sender as? GameSelectView else { return }
        guard let selectIndexPath = GameListTableView.indexPath(for: selectedCell) else { return }
        
        let allTeams = DataManager().getTeamList()
        teamSelectView.awayTeamButtonTitle = allTeams?[selectIndexPath.section][0]
        teamSelectView.homeTeamButtonTitle = allTeams?[selectIndexPath.section][1]
    }
}

extension GameSelectViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 1
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        guard let sectionNum = DataManager().getTeamList()?.count else { return 0 }
        
        return sectionNum
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "GameSelectCell", for: indexPath) as? GameSelectView else { return UITableViewCell() }
        
        let allTeams = DataManager().getTeamList()
        
        cell.GameCountLabel.text = "GAME \(indexPath.section + 1)"
        cell.AwayTeamLabel.text = allTeams?[indexPath.section][0] ?? "Away Team"
        cell.HomeTeamLabel.text = allTeams?[indexPath.section][1] ?? "Home Team"
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 20
    }

    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView()
        headerView.backgroundColor = .clear
        return headerView
    }

}

extension GameSelectViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "teamSelect", sender: tableView.cellForRow(at: indexPath))
    }
}

