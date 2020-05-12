import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import MainPage from "@MainPage/MainPage";
import GamePage from "@GamePage/GamePage";
import ErrorPage from "@ErrorPage/ErrorPage";
import ScoreBoard from "@/components/ScoreBoard/ScoreBoard";
import { ThemeProvider } from "styled-components";
import theme from "@/theme/theme";

const App = () => {
  return (
    <>
      <ThemeProvider theme={theme}>
        <BrowserRouter>
          <Switch>
            <Route path="/" exact component={MainPage} />
            <Route path="/game" exact component={GamePage} />
            <Route path="/scoreboard" exact component={ScoreBoard} />
            <Route component={ErrorPage} />
          </Switch>
        </BrowserRouter>
      </ThemeProvider>
    </>
  );
};

export default App;
