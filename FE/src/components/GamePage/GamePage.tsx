import React from "react";
import styled from "styled-components";
import ScoreBoard from "@GamePage/ScoreBoard/ScoreBoard";
import CurrentTurn from "@GamePage/CurrentTurn/CurrentTurn";
import BaseballField from "@GamePage/BaseballField/BaseballField";
import PlayerInfo from "@GamePage/PlayerInfo/PlayerInfo";

const Wrapper = styled.div`
  background-color: ${(props) => props.theme.colors.default.backgroundColor};
  height: 100vh;
  width: 100vw;
`;

const HeaderSection = styled.section`
  border-bottom: 1px solid ${(props) => props.theme.colors.default.borderColor};
  display: flex;
  height: 30vh;
  width: 100vw;
`;

const ScoreBoardWrapper = styled.div`
  background-color: ${(props) => props.theme.colors.default.backgroundColor};
  border-right: 1px solid ${(props) => props.theme.colors.default.borderColor};
  height: 100%;
  width: 70vw;
`;

const CurrentTurnWrapper = styled.div`
  height: 100%;
  width: 30vw;
`;

const PlayStatusSection = styled.section`
  display: flex;
  height: 70vh;
  width: 100vw;
`;

const GameStatus = styled.div`
  border-right: 1px solid ${(props) => props.theme.colors.default.borderColor};
  height: 100%;
  width: 70vw;
  display: flex;
  align-items: center;
`;

const PlayerInfoWrapper = styled.div`
  height: 100%;
  width: 30vw;
`;

const GamePage = () => {
  return (
    <Wrapper>
      <HeaderSection>
        <ScoreBoardWrapper>
          <ScoreBoard />
        </ScoreBoardWrapper>
        <CurrentTurnWrapper>
          <CurrentTurn />
        </CurrentTurnWrapper>
      </HeaderSection>
      <PlayStatusSection>
        <GameStatus>
          <BaseballField />
        </GameStatus>
        <PlayerInfoWrapper>
          <PlayerInfo />
        </PlayerInfoWrapper>
      </PlayStatusSection>
    </Wrapper>
  );
};

export default GamePage;
