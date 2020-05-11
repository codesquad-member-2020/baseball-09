import React, { useState, Dispatch } from "react";
import styled from "styled-components";
import Hitter from "@GamePage/BaseballField/Field/Hitter/Hitter";
import PitcherImg from "./pitcher.png";

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

enum EHit {
  Increase = 1,
}

enum EBase {
  HOME = 0,
  FIRST = 1,
  SECOND = 2,
  THIRD = 3,
  FOURTH = 4,
}

const Field = () => {
  const [base, setBase] = useState(EBase.HOME);

  const onClickHandler = () => {
    if (base + EHit.Increase === EBase.FOURTH) {
      setBase(EBase.HOME);
      return;
    }
    setBase(base + EHit.Increase);
  };

  return (
    <>
      <Playball onClick={onClickHandler}>PITCH!</Playball>
      <Pitcher src={PitcherImg} />
      <Hitter base={base} />
    </>
  );
};

export default Field;
