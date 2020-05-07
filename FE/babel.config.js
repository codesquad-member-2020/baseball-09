module.exports = {
  presets: [
    "@babel/preset-react",
    ["@babel/preset-env", { useBuiltIns: "usage", targets: { browsers: [">1%"] }, corejs: 3 }],
  ],
  plugins: ["@babel/proposal-class-properties", "@babel/syntax-dynamic-import"],
};
