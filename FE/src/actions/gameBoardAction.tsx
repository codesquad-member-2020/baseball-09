import { IGameBoard } from "@Model/gameBoard";

export type Action = { type: "UPDATE"; payload: IGameBoard };
