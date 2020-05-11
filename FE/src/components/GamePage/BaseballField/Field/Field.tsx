import React from "react";
import styled, { keyframes } from "styled-components";
import PitcherImg from "./fitcher.png";
import HitterImg from "./hitter.png";

const Playball = styled.button`
  position: absolute;
  color: white;
  font-family: sans-serif;
  font-size: 1.5em;
  cursor: pointer;
  background-color: #4682b4;
  border-radius: 5%;
  border: solid 1px #75b6ed;
  padding: 0.25em 1em;
  right: 43%;
  top: 47%;
  &:hover {
    background-color: #00008b;
  }
`;

const Pitcher = styled.img`
  height: 50px;
  position: absolute;
  right: 48%;
  top: 56%;
`;

const Hit = keyframes`
  100%{  
    transform: translate(230px, -240px);
  }
`;

const HitterWrap = styled.div`
  position: absolute;
  width: 50px;
  height: 50px;
  right: 48%;
  top: 86.5%;
  animation: ${Hit} 3s 1.2s linear 1;
  animation-fill-mode: forwards;
`;

const Hitter = styled.div`
  position: absolute;
  height: 100%;
  z-index: 100;
  .hitter-img {
    height: inherit;
  }
`;

const Field = () => {
  return (
    <>
      <Playball>PITCH!</Playball>
      <Pitcher src={PitcherImg} />
      <HitterWrap>
        <Hitter>
          <img className="hitter-img" src={HitterImg} />
        </Hitter>
      </HitterWrap>
    </>
  );
};

export default Field;