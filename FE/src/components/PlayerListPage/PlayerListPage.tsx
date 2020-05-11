import React from "react";
import styled from "styled-components";
import PlayerInfoList from "@/components/PlayerListPage/PlayerInfoList/PlayerInfoList";
import { IPlayerList, playerList } from "@/models/playerList";

const Wrapper = styled.div`
  background-color: #000;
  height: 100vh;
  width: 100vw;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const PlayerListContainer = styled.div`
  color: #fff;
  display: flex;
  justify-content: center;
  width: 900px;
  height: 500px;
  outline: solid 2px #fff;
`;

const PlayerListPage = () => {
  return (
    <Wrapper>
      <PlayerListContainer>
        {playerList &&
          playerList.map(({ teamName, players }: IPlayerList, index: number) => (
            <PlayerInfoList key={index} teamName={teamName} players={players} />
          ))}
      </PlayerListContainer>
    </Wrapper>
  );
};

export default PlayerListPage;
