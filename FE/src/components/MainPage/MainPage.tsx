import React, { useEffect } from "react";
import styled from "styled-components";
import GameSelectMenu from "@MainPage/GameSelectMenu/GameSelectMenu";
import BenchClearing from "./bench-clearing.jpg";

const Wrapper = styled.section`
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  background-image: url(${BenchClearing});
  background-repeat: no-repeat;
  background-size: cover;
  display: flex;
  flex-direction: column;
  height: 100vh;
  justify-content: space-around;
  width: 100vw;
  justify-content: center;
`;

const Header = styled.header`
  color: #ffffff;
  font-size: 2rem;
  font-weight: 900;
  text-transform: uppercase;
  height: 150px;
  &:hover {
    cursor: default;
  }
`;

const MainPage = () => {
  return (
    <Wrapper>
      <Header>Baseball Game Online</Header>
      <GameSelectMenu />
    </Wrapper>
  );
};

export default MainPage;
