import React from "react";
import styled from "styled-components";
import { IPlayerList, IPlayer } from "@/models/playerList";

const Wrapper = styled.table``;

const TeamTitle = styled.div``;

const Table = styled.div``;

const THeader = styled.thead``;

const TBody = styled.tbody``;

const PlayerInfoList = ({ teamName, players }: IPlayerList) => {
  return (
    <Wrapper>
      <TeamTitle>
        {teamName}
        {<span>Player</span>}
      </TeamTitle>
      <Table>
        <THeader>
          <tr>
            <th>타자</th>
            <th>타석</th>
            <th>안타</th>
            <th>아웃</th>
            <th>평균</th>
          </tr>
        </THeader>
        <TBody>
          {players.map(({ name, atBat, hits, outs }: IPlayer) => (
            <tr key={name + atBat + hits + outs}>
              <td>{name}</td>
              <td>{atBat}</td>
              <td>{hits}</td>
              <td>{outs}</td>
              <td>??</td>
            </tr>
          ))}
        </TBody>
      </Table>
    </Wrapper>
  );
};

export default PlayerInfoList;
