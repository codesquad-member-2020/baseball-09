import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import MainPage from "@/components/MainPage/MainPage";
import GamePage from "@/components/GamePage/GamePage";
import ErrorPage from "@/components/ErrorPage/ErrorPage";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={MainPage} />
          <Route path="/game" exact component={GamePage} />
          <Route component={ErrorPage} />
        </Switch>
      </BrowserRouter>
    </>
  );
};

export default App;
