import { Action } from "@/actions/playerAction";
import { PlayersState } from "@/contexts/playerContext";

type Method = "atBat" | "outs" | "hits";
const changePlayerStatus = (state: PlayersState, payloadId: number, method: Method) => {
  const targetPlayer = state.players.filter((player) => player.id === payloadId)[0];
  const players = [...state.players];
  players.splice(players.indexOf(targetPlayer), 1, {
    ...targetPlayer,
    [method]: targetPlayer[method] + 1,
  });

  return players;
};

const playersReducer = (state: PlayersState, action: Action): PlayersState => {
  switch (action.type) {
    case "HIT":
      return {
        ...state,
        players: changePlayerStatus(state, action.payload.id, "atBat"),
      };
    case "OUT":
      return {
        ...state,
        players: changePlayerStatus(state, action.payload.id, "outs"),
      };
    case "BALL":
      return {
        ...state,
        players: changePlayerStatus(state, action.payload.id, "atBat"),
      };
    case "STRIKE":
      return {
        ...state,
        players: changePlayerStatus(state, action.payload.id, "hits"),
      };
    default:
      throw new Error("Unhandled action");
  }
};

export default playersReducer;
