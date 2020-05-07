import React, { useState } from "react";
import styled from "styled-components";
import GameDispaly from "./GameDisplay/GameDisplay";
import { IGame, gameList } from "@/models/gameList";

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

const GameSelectMenu = () => {
  const [isGameAvailable, setIsGameAvailable] = useState<boolean>(true);

  return (
    <>
      <AvailInfoText>
        {isGameAvailable
          ? "참가할 게임을 선택하세요!"
          : "이미 선택된 팀입니다. 다른 팀을 선택해주세요!"}
      </AvailInfoText>
      <Wrapper>
        {gameList &&
          gameList.map((game: IGame) => {
            const { matchName, homeTeam, awayTeam, isAvailable } = game;
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
