import React, { useState } from "react";
import styled, { keyframes, Keyframes, css } from "styled-components";
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

const FirstHit = keyframes`
  100% {  
    transform: translate(230px, -240px);
  }
`;

const SecondHit = keyframes`
  100% {  
    transform: translate(-230px, -240px);
  }
`;

const ThirdHit = keyframes`
  100%{  
    transform: translate(-230px, 240px);
  }
`;

const FourthHit = keyframes`
  100%{  
    transform: translate(230px, 240px);
  }
`;

const HitterWrap = styled("div")<IHitterProp>`
  position: absolute;
  width: 50px;
  height: 50px;
  right: 48%;
  top: 86.5%;
  ${(props) => css`
    animation: ${props.active} 3s 1.2s linear 1;
    animation-fill-mode: forwards;
  `}
`;

const Hitter = styled.div`
  position: absolute;
  height: 100%;
  z-index: 100;
  .hitter-img {
    height: inherit;
  }
`;

const Hits = [FirstHit, SecondHit, ThirdHit, FourthHit];

interface IHitterProp {
  active: Keyframes;
}

const Field = () => {
  const [hit, setHit] = useState(-1);

  const onClickHandler = () => {
    if (hit + 1 === 4) setHit(-1);
    else setHit(hit + 1);
  };

  return (
    <>
      <Playball onClick={onClickHandler}>PITCH!</Playball>
      <Pitcher src={PitcherImg} />
      <HitterWrap active={Hits[hit]}>
        <Hitter>
          <img className="hitter-img" src={HitterImg} />
        </Hitter>
      </HitterWrap>
    </>
  );
};

export default Field;
