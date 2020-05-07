import gameListData from "./gameListData";

interface IGame {
  matchName: string;
  awayTeam: string;
  homeTeam: string;
  isAvailable: boolean;
}

const gameModel = (gameInfo: IGame) => {
  return gameInfo;
};

const gameList: IGame[] = [];
gameListData.forEach((game: IGame, index: number) => {
  gameList[index] = gameModel(game);
});

export { IGame, gameList };
