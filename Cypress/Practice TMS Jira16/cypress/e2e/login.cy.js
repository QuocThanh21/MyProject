const { NavigationPage } = require("../pages/navigation-page")
const { LoginPage } = require("../pages/login-page")
const { MessageConstants } =  require("../constants/message-constants")
const { UrlConstants } = require("../constants/url-constants")

describe('login spec', () => {
  beforeEach( function () {
    cy.fixture('account.json').as('account')
    cy.visit(UrlConstants.LOGIN_URL)
  })

  it('login successfully', function () {

    cy.login(this.account.validAccount.username, this.account.validAccount.password)
    NavigationPage.getUsername().should('contain.text', this.account.validAccount.username)
  })

  it('login unsucessfully with empty username', function () {
    LoginPage.inputPassword(this.account.validAccount.password)
    LoginPage.clickLoginBtn()
    LoginPage.getActualErrorRequiredUsernameMsg().should('contain.text', MessageConstants.EXPECTED_REQUIRED_FIELD_MESSAGE)
  })

  it('login unsucessfully with empty password', function () {

    LoginPage.inputUsername(this.account.validAccount.username)
    LoginPage.clickLoginBtn()
    LoginPage.getActualErrorRequiredPasswordMsg().should('contain.text', MessageConstants.EXPECTED_REQUIRED_FIELD_MESSAGE)
  })

  it('login unsucessfully with incorrect account', function () {
    cy.login(this.account.invalidAccount.username, this.account.invalidAccount.password)
    LoginPage.getActualIncorrectAccountMsg().should('contain.text', MessageConstants.EXPECTED_INCORRECT_ACCOUNT_MESSAGE)
  })

  afterEach( function () {
    cy.reload()
  })
})