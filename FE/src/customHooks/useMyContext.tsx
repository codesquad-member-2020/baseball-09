import { useContext } from "react";

export const useStateContext = (StateContext: React.Context<any>) => {
  const state = useContext(StateContext);
  if (!state) throw new Error("PlayersProvider not found");
  return state;
};

export const useDispatchContext = (DispatchContext: React.Context<any>) => {
  const dispatch = useContext(DispatchContext);
  if (!dispatch) throw new Error("PlayersProvider not found");
  return dispatch;
};
