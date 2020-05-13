export type Action =
  | { type: "STRIKE"; payload: { id: number } }
  | { type: "BALL"; payload: { id: number } }
  | { type: "OUT"; payload: { id: number } }
  | { type: "HIT"; payload: { id: number } };
