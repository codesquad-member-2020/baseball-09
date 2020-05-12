import React from "react";
import styled from "styled-components";

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
  padding: 2rem;
`;

const PlayerName = styled.span`
  color: ${(props) => props.theme.colors.default.secondaryStatColor};
  font-size: 2rem;
  margin-bottom: 1rem;
`;

const InfoWrapper = styled.div`
  display: flex;
  margin-bottom: 0.5rem;
  width: 100%;
`;

const NumberCount = styled.div`
  background-color: ${(props) => props.theme.colors.default.thirdStatColorFade};
  border-radius: 50%;
  color: ${(props) => props.theme.colors.default.thirdStatColor};
  display: inline-block;
  font-weight: 900;
  height: 25px;
  text-align: center;
  width: 25px;
`;

const NumberWrapper = styled.div`
  display: inline-block;
  width: 30%;
`;

const Judge = styled.span`
  color: ${(props) => props.theme.colors.default.thirdStatColor};
  font-size: 1.5rem;
  font-weight: 900;
  text-align: center;
  width: 40%;
`;

const Result = styled.span`
  color: ${(props) => props.theme.colors.default.thirdStatColor};
  font-size: 1.5rem;
  font-weight: 900;
  text-align: right;
  width: 30%;
`;

const LastResult = styled.span`
  color: ${(props) => props.theme.colors.default.fourthStatColor};
  font-size: 1.5rem;
  text-align: center;
  width: 40%;
`;

const Info = () => {
  return (
    <Wrapper>
      <PlayerName>7번 타자 이용대</PlayerName>
      <InfoWrapper>
        <NumberWrapper></NumberWrapper>
        <LastResult>안타!</LastResult>
      </InfoWrapper>
      <InfoWrapper>
        <NumberWrapper>
          <NumberCount>1</NumberCount>
        </NumberWrapper>
        <Judge>스트라이크</Judge>
        <Result>2S 1B</Result>
      </InfoWrapper>
      <InfoWrapper>
        <NumberWrapper>
          <NumberCount>2</NumberCount>
        </NumberWrapper>
        <Judge>볼</Judge>
        <Result>2S 1B</Result>
      </InfoWrapper>
      <InfoWrapper>
        <NumberWrapper>
          <NumberCount>1</NumberCount>
        </NumberWrapper>
        <Judge>스트라이크</Judge>
        <Result>2S 1B</Result>
      </InfoWrapper>
      <InfoWrapper>
        <NumberWrapper>
          <NumberCount>1</NumberCount>
        </NumberWrapper>
        <Judge>스트라이크</Judge>
        <Result>2S 1B</Result>
      </InfoWrapper>
      <InfoWrapper>
        <NumberWrapper>
          <NumberCount>1</NumberCount>
        </NumberWrapper>
        <Judge>스트라이크</Judge>
        <Result>2S 1B</Result>
      </InfoWrapper>
    </Wrapper>
  );
};

export default Info;
