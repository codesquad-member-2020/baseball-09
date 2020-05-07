import React from "react";
import styled from "styled-components";

const StatusWrapper = styled.div`
  background-color: #000000;
  display: flex;
  flex-direction: column;
  height: 100%;
  justify-content: space-around;
  width: 100%;
`;

const PlayerType = styled.span`
  color: #e2dddd;
  font-size: 2rem;
`;

const Player = styled.div`
  align-items: baseline;
  display: flex;
`;

const PlayerName = styled.span`
  color: #b4d1d7;
  font-size: 2rem;
`;

const PlayerStats = styled.span`
  color: #36545f;
  font-size: 1.5rem;
`;

const PlayerWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const CurrentTurn = () => {
  return (
    <StatusWrapper>
      <PlayerWrapper>
        <PlayerType>투수</PlayerType>
        <Player>
          <PlayerName>최동원</PlayerName>
          <PlayerStats>#39</PlayerStats>
        </Player>
      </PlayerWrapper>
      <PlayerWrapper>
        <PlayerType>타자</PlayerType>
        <Player>
          <PlayerName>류현진</PlayerName>
          <PlayerStats>1타석 0안타</PlayerStats>
        </Player>
      </PlayerWrapper>
    </StatusWrapper>
  );
};

export default CurrentTurn;
