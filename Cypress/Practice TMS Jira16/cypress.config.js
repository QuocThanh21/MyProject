/// <reference types="Cypress" />
const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    baseUrl: "http://192.168.237.10:3000"
  },

  env: {
    apiUrl: "http://192.168.237.10:3000",
    username: "Admin2",
    password: "qp$#tGu^",
  },
});
