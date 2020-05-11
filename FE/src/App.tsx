import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import MainPage from "@/components/MainPage/MainPage";
import GamePage from "@/components/GamePage/GamePage";
import ErrorPage from "@/components/ErrorPage/ErrorPage";
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
            <Route component={ErrorPage} />
          </Switch>
        </BrowserRouter>
      </ThemeProvider>
    </>
  );
};

export default App;
