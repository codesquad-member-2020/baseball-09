import { createContext, Dispatch } from "react";
import { Action } from "@/actions/playerAction";
import { IPlayerList } from "@/models/playerList";

type PlayersState = IPlayerList;
type PlayersDispatch = Dispatch<Action>;

const PlayersStateContext = createContext<PlayersState | undefined>(undefined);
const PlayersDispatchContext = createContext<PlayersDispatch | undefined>(undefined);

export { PlayersState, PlayersDispatch, PlayersStateContext, PlayersDispatchContext };
