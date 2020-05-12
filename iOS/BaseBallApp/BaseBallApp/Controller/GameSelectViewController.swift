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
    
    private var viewModel: GameSelectViewModel?
    private let dataUseCase = DataUseCase()
    
    private var gameSelectAlert: UIAlertController!
    
    private let cellIdentifier = "GameSelectCell"
    private let cellNibName = "GameSelectView"
    private let nextViewSegueIdentifier = "teamSelect"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dataUseCase.loadTeamList(manager: NetworkManager()) { (decodeData) in
            self.viewModel = GameSelectViewModel(gameList: decodeData)
            DispatchQueue.main.async {
                self.GameListTableView.reloadData()
            }
        }
        
        GameListTableView.delegate = self
        GameListTableView.dataSource = self
        
        registGameListTableViewCell()
        
        setAlertController()
    }
    
    private func registGameListTableViewCell() {
        let cellNib = UINib(nibName: cellNibName, bundle: nil)
        GameListTableView.register(cellNib, forCellReuseIdentifier: cellIdentifier)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let teamSelectView = segue.destination as? TeamSelectViewController else { return }
        guard let selectedCell = sender as? GameSelectView else { return }
        guard let selectIndexPath = GameListTableView.indexPath(for: selectedCell) else { return }
        
        if viewModel?.gameList[selectIndexPath.section].started == true {
            present(gameSelectAlert, animated: true, completion: nil)
            return
        }
        
        teamSelectView.awayTeamButtonTitle = viewModel?.gameList[selectIndexPath.section].away
        teamSelectView.homeTeamButtonTitle = viewModel?.gameList[selectIndexPath.section].home
        
        teamSelectView.awayTeamId = viewModel?.gameList[selectIndexPath.section].awayId
        teamSelectView.homeTeamId = viewModel?.gameList[selectIndexPath.section].homeId
    }
    
    private func setAlertController() {
        gameSelectAlert = UIAlertController(title: "게임 선택 불가", message: "이미 진행중인 게임입니다.", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        gameSelectAlert.addAction(okAction)
    }
}

extension GameSelectViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 1
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        guard let sectionNum = viewModel?.gameList.count else { return 0 }
        
        return sectionNum
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath) as? GameSelectView else { return UITableViewCell() }
        
        cell.GameCountLabel.text = "GAME \(indexPath.section + 1)"
        cell.AwayTeamLabel.text = viewModel?.gameList[indexPath.section].away
        cell.HomeTeamLabel.text = viewModel?.gameList[indexPath.section].home
        
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
        performSegue(withIdentifier: nextViewSegueIdentifier, sender: tableView.cellForRow(at: indexPath))
    }
}

