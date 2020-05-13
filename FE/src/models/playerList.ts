interface IPlayerList {
  teamName: string;
  players: IPlayer[];
}

interface IPlayer {
  id: number;
  name: string;
  atBat: number;
  hits: number;
  outs: number;
}

export { IPlayerList, IPlayer };
