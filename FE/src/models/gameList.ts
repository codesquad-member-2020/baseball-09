interface IGame {
  matchName: string;
  awayTeam: string;
  homeTeam: string;
  isAvailable: boolean;
}

interface IGameList {
  [index: number]: IGame;
}
