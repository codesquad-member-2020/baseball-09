import React from "react";
import styled from "styled-components";

const Header = styled.div`
  position: absolute;
  height: 20%;
  width: 100%;
  z-index: 100;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  padding: 5px 20px;
  font-size: 24px;
  font-weight: 600;
  color: ${(props) => props.theme.colors.default.fontColor};
  .status-wrap {
    flex-direction: column;
  }
  .status {
    display: flex;
    height: 40px;
    align-items: center;
  }
  .title {
    width: 30px;
    margin: 0;
  }
`;

const Ball = styled.span`
  color: ${(props) => props.theme.colors.default.ballColor};
`;

const Strike = styled.span`
  color: ${(props) => props.theme.colors.default.strikeColor};
`;

const Out = styled.span`
  color: ${(props) => props.theme.colors.default.outColor};
`;

const CurrentInfo = () => {
  return (
    <div>
      <Header>
        <div className="status-wrap">
          <div className="status">
            <Strike className="title">S</Strike>
            <Strike>●</Strike>
            <Strike>●</Strike>
            <Strike>●</Strike>
          </div>
          <div className="status">
            <Ball className="title">B</Ball>
            <Ball>●</Ball>
            <Ball>●</Ball>
          </div>
          <div className="status">
            <Out className="title">O</Out>
            <Out>●</Out>
            <Out>●</Out>
          </div>
        </div>
        <p>2회초 수비</p>
      </Header>
    </div>
  );
};

export default CurrentInfo;
