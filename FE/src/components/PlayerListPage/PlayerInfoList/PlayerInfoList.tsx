import React from "react";
import styled from "styled-components";
import { IPlayerList, IPlayer } from "@/models/playerList";

const Wrapper = styled.table`
  width: 50%;
  height: 100%;
  &:first-child {
    border-right: solid 2px #fff;
  }
`;

const TeamTitle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: 600;
  font-size: 2rem;
  margin: 0 10px;
  padding: 10px 0;
  border-bottom: solid 2px #fff;
  span {
    color: red;
    font-size: 1rem;
    margin-left: 10px;
  }
`;

const Table = styled.div`
  display: flex;
  justify-content: start;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 87%;
`;

const THeader = styled.thead`
  width: 95.8%;
  font-size: 1.2rem;
  color: #939393b5;
  margin: 0 5px;
  padding: 5px 0;
  border-bottom: solid 2px #939393b5;
  tr {
    display: flex;
    justify-content: space-around;
  }
`;

const TBody = styled.tbody`
  width: 95.8%;
  display: flex;
  height: 80%;
  flex-wrap: wrap;
  align-items: inherit;
  padding: 5px 0;
  tr {
    display: flex;
    width: 100%;
    justify-content: space-around;
    padding: 4px 0;
    font-size: 1.2rem;
    border-bottom: solid 1px #9393935c;
  }
  td {
    width: 20%;
    text-align: center;
  }
`;

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
