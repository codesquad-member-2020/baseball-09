import React from "react";
import styled from "styled-components";
import CurrentInfo from "@/components/GamePage/BaseballField/CurrentInfo/CurrentInfo";
import Field from "@/components/GamePage/BaseballField/Field/Field";
import FieldImg from "./field.png";

const Wrapper = styled.div`
  margin: auto;
  width: 800px;
  height: inherit;
  padding: 10px 0;
  perspective: 800px;
  transform-style: preserve-3d;
  transition: transform 1s ease-in;
`;

const FieldWrap = styled.div`
  position: relative;
  height: inherit;
  background: url(${FieldImg}) no-repeat center;
  background-size: contain;
`;

const BaseballField = () => {
  return (
    <>
      <Wrapper>
        <CurrentInfo />
        <FieldWrap>
          <Field />
        </FieldWrap>
      </Wrapper>
    </>
  );
};

export default BaseballField;
