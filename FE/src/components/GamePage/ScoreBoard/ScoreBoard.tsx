import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  background-color: ${(props) => props.theme.colors.default.backgroundColor};
  text-transform: uppercase;
  font-size: 2rem;
  font-weight: 900;
  text-align: center;
`;

const Header = styled.header`
  color: ${(props) => props.theme.colors.default.fontColor};
`;

const Names = styled.div`
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 30%;
  position: relative;
`;

const TeamName = styled.span`
  color: ${(props) => props.theme.colors.default.fontColor};
  display: inline-block;
  font-size: 3rem;
  font-weight: 900;
  text-align: center;
`;

const Versus = styled.span`
  color: ${(props) => props.theme.colors.default.fontColor};
  display: inline-block;
  font-size: 1.5rem;
  font-weight: 900;
  line-heigth: 50%;
  width: 10%;
`;

const TeamScore = styled.span`
  color: ${(props) => props.theme.colors.default.fontColor};
  display: inline-block;
  font-size: 3rem;
  font-weight: 900;
  width: 7.5%;
`;

const Teams = styled.div`
  align-items: center;
  display: flex;
  justify-content: center;
  margin-top: 1rem;
  width: 100%;
`;

const Selected = styled.span`
  color: ${(props) => props.theme.colors.default.playerSelected};
  width: 30%;
  position: absolute;
  top: 100%;
  left: 25%;
`;

const ScoreBoard = () => {
  return (
    <Wrapper>
      <Header>Baseball Game Online</Header>
      <Teams>
        <Names>
          <TeamName>Captain</TeamName>
          <Selected>Player</Selected>
        </Names>
        <TeamScore>1</TeamScore>
        <Versus>vs</Versus>
        <TeamScore>5</TeamScore>
        <Names>
          <TeamName>Marvel</TeamName>
        </Names>
      </Teams>
    </Wrapper>
  );
};

export default ScoreBoard;
