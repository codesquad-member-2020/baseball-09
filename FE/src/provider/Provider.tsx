import React, { createContext, Dispatch, useReducer } from "react";
import playersReducer from "@/reducers/playerReducer";
import { PlayersStateContext, PlayersDispatchContext } from "@/contexts/playerContext";
import playerListData from "@/models/playerListData";
import { IPlayerList } from "@/models/playerList";

export const ContextProvider = ({ children }: { children: React.ReactNode }) => {
  const [players, playersDispatch] = useReducer(playersReducer, playerListData as IPlayerList);

  return (
    <PlayersDispatchContext.Provider value={playersDispatch}>
      <PlayersStateContext.Provider value={players}>{children}</PlayersStateContext.Provider>
    </PlayersDispatchContext.Provider>
  );
};
