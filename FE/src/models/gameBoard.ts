interface IGameBoard {
  gameId: number;
  inning: number;
  scores: number[];
  sbo: ISbo;
  game: IGame;
  bottom: boolean;
}

interface IGame {
  home: IHome;
  away: IHome;
}

interface IHome {
  id: number;
  teamId: number;
  name: string;
  battingAverage: number;
  pitcher: boolean;
}

interface ISbo {
  strike: number;
  ball: number;
  out: number;
  hit: number;
}

export { IGameBoard };
