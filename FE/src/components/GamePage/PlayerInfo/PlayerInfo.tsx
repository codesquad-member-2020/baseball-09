import React from "react";
import styled from "styled-components";
import Info from "@GamePage/PlayerInfo/Info/Info";

const Wrapper = styled.div`
  background-color: #000000;
  height: 100%;
  overflow-y: scroll;
  &::-webkit-scrollbar {
    display: none;
  }
`;
const PlayerInfo = () => {
  return (
    <Wrapper>
      <Info />
      <Info />
      <Info />
    </Wrapper>
  );
};

export default PlayerInfo;
