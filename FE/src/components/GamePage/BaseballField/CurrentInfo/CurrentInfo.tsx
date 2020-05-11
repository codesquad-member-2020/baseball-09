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
  color: #fff;
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

const CurrentInfo = () => {
  return (
    <div>
      <Header>
        <div className="status-wrap">
          <div className="status">
            <p className="title">S</p>
            <span>●</span>
            <span>●</span>
            <span>●</span>
          </div>
          <div className="status">
            <p className="title">B</p>
            <span>●</span>
            <span>●</span>
          </div>
          <div className="status">
            <p className="title">O</p>
            <span>●</span>
            <span>●</span>
          </div>
        </div>
        <p>2회초 수비</p>
      </Header>
    </div>
  );
};

export default CurrentInfo;
