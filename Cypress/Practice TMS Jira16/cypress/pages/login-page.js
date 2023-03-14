const LOGIN_URL = "/#!/login";
const TXT_USERNAME = "#username";
const TXT_PASSWORD = "#password";
const BTN_LOGIN = "input[value='Login']";
const LBL_ERROR_INCORRECT_ACCOUNT = "div[ng-show='isError']";
const LBL_ERROR_REQUIRED_USERNAME = "//input[@id='username']/following-sibling::div/p";
const LBL_ERROR_REQUIRED_PASSWORD = "//input[@id='password']/following-sibling::div/p";


export const LoginPage = {
    inputUsername (username){
        cy.get(TXT_USERNAME).type(username)
    },

    inputPassword(password){
        cy.get(TXT_PASSWORD).type(password)
    },

    clickLoginBtn(){
        cy.get(BTN_LOGIN).click()
    },

    getActualIncorrectAccountMsg(){
        return cy.get(LBL_ERROR_INCORRECT_ACCOUNT)
    },

    getActualErrorRequiredUsernameMsg(){
        return cy.xpath(LBL_ERROR_REQUIRED_USERNAME)
    },

    getActualErrorRequiredPasswordMsg(){
        return cy.xpath(LBL_ERROR_REQUIRED_PASSWORD)
    }  
}