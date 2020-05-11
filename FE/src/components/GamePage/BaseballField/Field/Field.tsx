import React, { useState, Dispatch } from "react";
import styled from "styled-components";
import Hitter from "@/components/GamePage/BaseballField/Field/Hitter/hitter";
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

enum FieldState {
  InitState = -1,
  MaxState = 4,
  Increase = 1,
}

const Field = () => {
  const [hit, setHit] = useState(FieldState.InitState);

  const onClickHandler = () => {
    if (hit + FieldState.Increase === FieldState.MaxState) setHit(FieldState.InitState);
    else setHit(hit + FieldState.Increase);
  };

  return (
    <>
      <Playball onClick={onClickHandler}>PITCH!</Playball>
      <Pitcher src={PitcherImg} />
      <Hitter hit={hit} />
    </>
  );
};

export default Field;
