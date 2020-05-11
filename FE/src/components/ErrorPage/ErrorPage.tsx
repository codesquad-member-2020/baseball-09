import React from "react";
import styled from "styled-components";

const Wrapper = styled.section`
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  background-image: url(TrapCard.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  color: #ffffff;
  display: flex;
  flex-direction: column;
  font-size: 5rem;
  height: 100vh;
  justify-content: space-around;
  width: 100vw;
`;

const ErrorPage = () => {
  return <Wrapper>잘못된 경로입니다</Wrapper>;
};

export default ErrorPage;
