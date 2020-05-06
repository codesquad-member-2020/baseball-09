import React from "react";
import styled from "styled-components";
import GameDispaly from "./GameDisplay/GameDisplay";
import { IGame, gameList } from "@/models/gameList";

const Wrapper = styled.div`
  width: 400px;
  overflow-y: scroll;
  &::-webkit-scrollbar {
    display: none;
  }
  .visible-wrapper {
    height: 400px;
  }
`;

const SelectText = styled.h2`
  color: #ffffff;
  text-align: center;
`;

const GameSelectMenu = () => {
  return (
    <>
      <SelectText>참가할 게임을 선택하세요!</SelectText>
      <Wrapper>
        <div className="visible-wrapper">
          {gameList &&
            gameList.map((game: IGame, index: number) => {
              const { matchName, homeTeam, awayTeam, isAvailable } = game;

              return (
                <GameDispaly
                  matchName={matchName}
                  homeTeam={homeTeam}
                  awayTeam={awayTeam}
                  isAvailable={isAvailable}
                  key={index}
                />
              );
            })}
        </div>
      </Wrapper>
    </>
  );
};

export default GameSelectMenu;
