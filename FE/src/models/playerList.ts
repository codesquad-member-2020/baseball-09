import playerListData from "./playerListData";

interface IPlayerList {
  teamName: string;
  players: IPlayer[];
}

interface IPlayer {
  name: string;
  atBat: number;
  hits: number;
  outs: number;
}

const getPlayerList = (playerListInfo: IPlayerList) => {
  return playerListInfo;
};

const playerList: IPlayerList[] = [];
playerListData.forEach((player: IPlayerList, index: number) => {
  playerList[index] = getPlayerList(player);
});

export { IPlayerList, IPlayer, playerList };
