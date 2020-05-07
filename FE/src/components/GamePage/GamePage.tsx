import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  background-color: #000000;
  height: 100vh;
  width: 100vw;
`;

const HeaderSection = styled.section`
  display: flex;
  border-bottom: 1px solid white;
  height: 30vh;
  width: 100vw;
`;

const ScoreBoard = styled.div`
  border-right: 1px solid white;
  background-color: red;
  width: 70vw;
  height: 100%;
`;

const CurrentTurn = styled.div`
  background-color: skyblue;
  width: 30vw;
  height: 100%;
`;

const PlayStatusSection = styled.section`
  display: flex;
  height: 70vh;
  width: 100vw;
  background-color: blue;
`;

const GameStatus = styled.div`
  border-right: 1px solid white;
  background-color: green;
  width: 70vw;
  height: 100%;
`;

const PlayerInfo = styled.div`
  background-color: purple;
  height: 100%;
  width: 30vw;
`;

const GamePage = () => {
  return (
    <Wrapper>
      <HeaderSection>
        <ScoreBoard />
        <CurrentTurn />
      </HeaderSection>
      <PlayStatusSection>
        <GameStatus></GameStatus>
        <PlayerInfo></PlayerInfo>
      </PlayStatusSection>
    </Wrapper>
  );
};

export default GamePage;
