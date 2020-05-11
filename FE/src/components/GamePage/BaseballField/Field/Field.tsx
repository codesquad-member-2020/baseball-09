import React, { useState, Dispatch } from "react";
import styled from "styled-components";
import Hitter from "@GamePage/BaseballField/Field/Hitter/Hitter";
import PitcherImg from "./pitcher.png";

const Playball = styled.button`
  position: absolute;
  color: ${(props) => props.theme.colors.default.fontColor};
  font-family: sans-serif;
  font-size: 1.5em;
  cursor: pointer;
  background-color: ${(props) => props.theme.colors.default.buttonColor};
  border-radius: 5%;
  border: solid 1px #75b6ed;
  padding: 0.25em 1em;
  right: 43%;
  top: 47%;
  &:hover {
    background-color: ${(props) => props.theme.colors.default.buttonFadeColor};
  }
`;

const Pitcher = styled.img`
  height: 50px;
  position: absolute;
  right: 48%;
  top: 56%;
`;

export enum EBase {
  HOME = 0,
  FIRST = 1,
  SECOND = 2,
  THIRD = 3,
  FOURTH = 4,
}

const Field = () => {
  const [base, setBase] = useState(0);

  const onClickHandler = () => {
    if (base + 1 === (EBase.FOURTH as number)) {
      setBase(EBase.HOME as number);
      return;
    }
    const nextBase = base + 1;
    setBase(nextBase);
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
