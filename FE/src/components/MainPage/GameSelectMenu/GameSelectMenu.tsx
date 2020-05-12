import React, { useState } from "react";
import styled from "styled-components";
import GameDispaly from "./GameDisplay/GameDisplay";
import { IGame, gameList } from "@Model/gameList";
import useFetch from "@/customHooks/useFetch";

const Wrapper = styled.div`
  height: 400px;
  overflow-y: scroll;
  width: 500px;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const AvailInfoText = styled.div`
  color: #ffffff;
  font-size: 2rem;
  margin-bottom: 1rem;
  text-align: center;
  &:hover {
    cursor: default;
  }
`;

const DIV = styled.div`
  font-size: 5rem;
  color: #000;
`;

interface IServerGame {
  id: number;
  homeId: number;
  awayId: number;
  home: string;
  away: string;
  started: boolean;
}

const GameSelectMenu = () => {
  const [isGameAvailable, setIsGameAvailable] = useState<boolean>(true);
  const { response, isLoading } = useFetch(`${process.env.API_ADDRESS}/main`, {
    method: "GET",
  });
  if (isLoading) {
    return <DIV>로딩 중이다...</DIV>;
  }

  return (
    <>
      <AvailInfoText>
        {isGameAvailable
          ? "참가할 게임을 선택하세요!"
          : "이미 선택된 팀입니다. 다른 팀을 선택해주세요!"}
      </AvailInfoText>
      <Wrapper>
        {response &&
          response.map((game: IServerGame) => {
            const matchName = game.homeId.toString();
            const homeTeam = game.home;
            const awayTeam = game.away;
            const isAvailable = game.started;

            return (
              <GameDispaly
                matchName={matchName}
                homeTeam={homeTeam}
                awayTeam={awayTeam}
                isAvailable={isAvailable}
                key={matchName + homeTeam + awayTeam}
                clickHandler={() => setIsGameAvailable(isAvailable)}
              />
            );
          })}
      </Wrapper>
    </>
  );
};

export default GameSelectMenu;
