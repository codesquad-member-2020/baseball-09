import React from "react";
import styled from "styled-components";
import GameDispaly from "./GameDisplay/GameDisplay";

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 400px;
  width: 400px;
`;

const SelectText = styled.span`
  color: #ffffff;
  text-align: center;
`;

const GameSelectMenu = () => {
  return (
    <Wrapper>
      <SelectText>참가할 게임을 선택하세요!</SelectText>
      <GameDispaly homeTeam={"Captain"} awayTeam={"Tigers"} />
      <GameDispaly homeTeam={"Twins"} awayTeam={"Marvel"} />
      <GameDispaly homeTeam={"Rockets"} awayTeam={"Dodgers"} />
    </Wrapper>
  );
};

export default GameSelectMenu;
