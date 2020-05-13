import { Action } from "@/actions/playerAction";
import { PlayersState } from "@/contexts/playerContext";

const playersReducer = (state: PlayersState, action: Action): PlayersState => {
  switch (action.type) {
    case "HIT":
      return {
        ...state,
      };
    case "OUT":
      return {
        ...state,
      };
    case "BALL":
      return {
        ...state,
      };
    case "STRIKE":
      return {
        ...state,
      };
    default:
      throw new Error("Unhandled action");
  }
};

export default playersReducer;
