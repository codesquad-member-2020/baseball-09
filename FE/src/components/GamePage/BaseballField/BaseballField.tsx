import React from "react";
import styled, { keyframes } from "styled-components";
import CurrentInfo from "@/components/GamePage/BaseballField/CurrentInfo/CurrentInfo";
import Pitcher from "./fitcher.png";
import HitterImg from "./hitter.png";
import Field from "./field.png";

const Wrapper = styled.div`
  margin: auto;
  width: 800px;
  height: inherit;
  padding: 10px 0;
  -webkit-perspective: 800px;
  transform-style: preserve-3d;
  transition: transform 1s ease-in;
  .field {
    position: relative;
    height: inherit;
    background: url(${Field}) no-repeat center;
    background-size: contain;
  }
`;

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

const PitcherImg = styled.img`
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

const BaseballField = () => {
  return (
    <>
      <Wrapper>
        <CurrentInfo />
        <div className="field">
          <Playball>PITCH!</Playball>
          <PitcherImg src={Pitcher} />
          <HitterWrap>
            <Hitter>
              <img className="hitter-img" src={HitterImg} />
            </Hitter>
          </HitterWrap>
        </div>
      </Wrapper>
    </>
  );
};

export default BaseballField;
