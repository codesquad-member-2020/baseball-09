import React from "react";
import styled from "styled-components";
import GameSelectMenu from "@MainPage/GameSelectMenu/GameSelectMenu";
import { useStateContext, useDispatchContext } from "@/customHooks/useMyContext";
import { PlayersStateContext, PlayersDispatchContext } from "@/contexts/playerContext";
import { GameBoardStateContext, GameBoardDispatchContext } from "@/contexts/gameBoardContext";
import BenchClearing from "./bench-clearing.jpg";

const Wrapper = styled.section`
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  background-image: url(${BenchClearing});
  background-repeat: no-repeat;
  background-size: cover;
  display: flex;
  flex-direction: column;
  height: 100vh;
  justify-content: space-around;
  width: 100vw;
  justify-content: center;
`;

const Header = styled.header`
  color: #ffffff;
  font-size: 2rem;
  font-weight: 900;
  text-transform: uppercase;
  height: 150px;
  &:hover {
    cursor: default;
  }
`;

const MainPage = () => {
  const playersState = useStateContext(PlayersStateContext);
  const playersDispatch = useDispatchContext(PlayersDispatchContext);
  const gameBoardState = useStateContext(GameBoardStateContext);
  const gameBoardDispatch = useDispatchContext(GameBoardDispatchContext);

  const onClick = (e: any) => {
    e.preventDefault();
    playersDispatch({
      type: "OUT",
      payload: { id: 3 },
    });
    gameBoardDispatch({
      type: "UPDATE",
      payload: {
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
      },
    });
  };

  return (
    <Wrapper>
      <Header onClick={onClick}>Baseball Game Online</Header>
      <GameSelectMenu />
    </Wrapper>
  );
};

export default MainPage;
