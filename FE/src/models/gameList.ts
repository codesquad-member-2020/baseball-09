import gameListData from "./gameListData";

interface IGame {
  matchName: string;
  awayTeam: string;
  homeTeam: string;
  isAvailable: boolean;
}

interface IGameList {
  [index: number]: IGame;
}

const gameModel = (gameInfo: IGame) => {
  return gameInfo;
};

const gameList: IGameList = [];
gameListData.forEach((game: IGame, index: number) => {
  gameList[index] = gameModel(game);
});

export default gameList;
