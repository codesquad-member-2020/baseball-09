import { createContext, Dispatch } from "react";
import { Action } from "@/actions/gameBoardAction";
import { IGameBoard } from "@Model/gameBoard";

type GameBoardState = IGameBoard;
type GameBoardDispatch = Dispatch<Action>;

const GameBoardStateContext = createContext<GameBoardState | undefined>(undefined);
const GameBoardDispatchContext = createContext<GameBoardDispatch | undefined>(undefined);

export { GameBoardState, GameBoardDispatch, GameBoardStateContext, GameBoardDispatchContext };
