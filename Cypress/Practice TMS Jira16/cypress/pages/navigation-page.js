const LBL_USERNAME_IN_NAVBAR = "//img[@id='ava']/parent::a";

export const NavigationPage = {
    getUsername(){
        return cy.xpath(LBL_USERNAME_IN_NAVBAR)
    }
}