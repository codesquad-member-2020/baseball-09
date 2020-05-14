import { Action } from "@/actions/gameBoardAction";
import { GameBoardState } from "@/contexts/gameBoardContext";

const gameBoardReducer = (state: GameBoardState, action: Action): GameBoardState => {
  switch (action.type) {
    case "UPDATE":
      return {
        ...action.payload,
      };
    default:
      throw new Error("Unhandled action");
  }
};

export default gameBoardReducer;
