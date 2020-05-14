import React, { useReducer } from "react";
import playersReducer from "@/reducers/playerReducer";
import gameBoardReducer from "@/reducers/gameBoardReducer";
import { PlayersStateContext, PlayersDispatchContext } from "@/contexts/playerContext";
import { GameBoardStateContext, GameBoardDispatchContext } from "@/contexts/gameBoardContext";
import playerListData from "@/models/playerListData";
import { IPlayerList } from "@/models/playerList";
import { IGameBoard } from "@/models/gameBoard";

export const ContextProvider = ({ children }: { children: React.ReactNode }) => {
  const [players, playersDispatch] = useReducer(playersReducer, playerListData as IPlayerList);
  const [gameBoard, gameBoardDispatch] = useReducer(gameBoardReducer, {
    gameId: 1,
    inning: 1,
    scores: [],
    sbo: {
      strike: 0,
      ball: 3,
      out: 0,
      hit: 2,
    },
    game: {
      home: {
        id: 1,
        teamId: 1,
        name: "양성우",
        battingAverage: 168,
        pitcher: true,
      },
      away: {
        id: 8,
        teamId: 2,
        name: "오재일",
        battingAverage: 293,
        pitcher: false,
      },
    },
    bottom: false,
  } as IGameBoard);

  return (
    <PlayersDispatchContext.Provider value={playersDispatch}>
      <PlayersStateContext.Provider value={players}>
        <GameBoardDispatchContext.Provider value={gameBoardDispatch}>
          <GameBoardStateContext.Provider value={gameBoard}>
            {children}
          </GameBoardStateContext.Provider>
        </GameBoardDispatchContext.Provider>
      </PlayersStateContext.Provider>
    </PlayersDispatchContext.Provider>
  );
};
