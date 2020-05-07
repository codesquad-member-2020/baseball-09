import React from "react";
import styled from "styled-components";
import { IGame } from "@/models/gameList";

const Header = styled.header`
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
  display: inline-block;
  font-size: 2rem;
  font-weight: 900;
  text-align: center;
  width: 45%;
`;

const Wrapper = styled("div")<{ isAvailable: boolean }>`
  align-items: space-around;
  background-color: #${(props: any) => (props.isAvailable ? `b4b5b6` : `b4b5b6a6`)};
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  height: 100px;
  justify-content: center;
  & + & {
    margin: 50px 0;
  }
  ${Header},
  ${TeamName} {
    color: #${(props: any) => (props.isAvailable ? `000` : `d32a34`)};
  }
`;

interface IGameDisplayProps {
  matchName: string;
  awayTeam: string;
  homeTeam: string;
  isAvailable: boolean;
  onClick: (event: React.MouseEvent<HTMLElement>) => void;
}

const GameDisplay = (props: IGameDisplayProps) => {
  const { matchName, homeTeam, awayTeam, isAvailable, onClick } = props;

  return (
    <Wrapper onClick={onClick} isAvailable={isAvailable}>
      <Header>{matchName}</Header>
      <div>
        <TeamName>{homeTeam}</TeamName>
        <Versus>vs</Versus>
        <TeamName>{awayTeam}</TeamName>
      </div>
    </Wrapper>
  );
};

export default GameDisplay;
