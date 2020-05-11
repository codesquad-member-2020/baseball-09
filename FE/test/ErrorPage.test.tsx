import React from "react";
import { render } from "@testing-library/react";
import "@testing-library/jest-dom";
import ErrorPage from "../src/components/ErrorPage/ErrorPage";

describe("<ErrorPage />", () => {
  it("renders 잘못된 경로입니다", () => {
    const { getByText } = render(<ErrorPage />);
    const body = getByText("잘못된 경로입니다");
    expect(body).toBeInTheDocument();
  });
});
