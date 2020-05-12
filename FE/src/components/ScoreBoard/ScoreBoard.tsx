import React from "react";
import styled from "styled-components";

const Table = styled.table`
  background-color: ${(props) => props.theme.colors.default.backgroundColor};
  border-collapse: collapse;
  height: 100%;
  width: 100%;
`;

const TableHeader = styled.thead`
  border-bottom: 1px solid ${(props) => props.theme.colors.default.borderColor};
  margin-bottom: 3rem;
`;

const TeamCategory = styled.th`
  color: ${(props) => props.theme.colors.default.primaryFontColor};
  font-size: 2rem;
  text-align: center;
  width: 15%;
`;

const InningCategory = styled.th`
  color: ${(props) => props.theme.colors.default.primaryFontColor};
  font-size: 2rem;
  text-align: center;
  width: calc(70% / 15);
`;

const SumCategory = styled.th`
  color: ${(props) => props.theme.colors.default.primaryFontColor};
  font-size: 2rem;
  text-align: center;
  width: 15%;
`;

const TeamName = styled.td`
  color: ${(props) => props.theme.colors.default.thirdFontColor};
  font-size: 1.5rem;
  font-weight: 900;
  text-align: center;
`;

const ScoreText = styled.td`
  color: ${(props) => props.theme.colors.default.secondaryFontColor};
  font-size: 1.5rem;
  font-weight: 800;
  text-align: center;
`;

const SumText = styled.td`
  color: ${(props) => props.theme.colors.default.fourthFontColor};
  font-size: 1.5rem;
  font-weight: 800;
  text-align: center;
`;

const ScoreBoard = () => {
  return (
    <Table>
      <TableHeader>
        <tr>
          <TeamCategory>팀</TeamCategory>
          <InningCategory>1</InningCategory>
          <InningCategory>2</InningCategory>
          <InningCategory>3</InningCategory>
          <InningCategory>4</InningCategory>
          <InningCategory>5</InningCategory>
          <InningCategory>6</InningCategory>
          <InningCategory>7</InningCategory>
          <InningCategory>8</InningCategory>
          <InningCategory>9</InningCategory>
          <InningCategory>10</InningCategory>
          <InningCategory>11</InningCategory>
          <InningCategory>12</InningCategory>
          <SumCategory>total</SumCategory>
        </tr>
      </TableHeader>
      <tbody>
        <tr>
          <TeamName>Captain</TeamName>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>2</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <SumText>6</SumText>
        </tr>
        <tr>
          <TeamName>Marvel</TeamName>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>1</ScoreText>
          <ScoreText>2</ScoreText>
          <ScoreText>0</ScoreText>
          <ScoreText>0</ScoreText>
          <SumText>6</SumText>
        </tr>
      </tbody>
    </Table>
  );
};

export default ScoreBoard;
