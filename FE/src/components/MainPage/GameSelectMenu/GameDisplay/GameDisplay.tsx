import React from "react";
import styled from "styled-components";
import { IGame } from "@/models/gameList";

const Wrapper = styled.div`
  align-items: space-around;
  background-color: #b4b5b6;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  height: 100px;
  justify-content: center;
  & + & {
    margin: 50px 0;
  }
`;

const Header = styled.header`
  color: #d32a34;
  font-size: 1rem;
  text-align: center;
  text-transform: uppercase;
  width: 100%;
`;

const Versus = styled.span`
  color: #434249;
  display: inline-block;
  font-weight: 900;
  height: 100%;
  text-align: center;
  text-transform: uppercase;
  width: 10%;
`;

const TeamName = styled.span`
  color: #d32a34;
  display: inline-block;
  font-size: 2rem;
  font-weight: 900;
  text-align: center;
  width: 45%;
`;

const GameDisplay = (props: IGame) => {
  const { matchName, homeTeam, awayTeam, isAvailable } = props;

  return (
    <Wrapper>
      <Header>
        {matchName} {isAvailable}
      </Header>
      <div>
        <TeamName>{homeTeam}</TeamName>
        <Versus>vs</Versus>
        <TeamName>{awayTeam}</TeamName>
      </div>
    </Wrapper>
  );
};

export default GameDisplay;
