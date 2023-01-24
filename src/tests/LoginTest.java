package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductsListPage;

public class LoginTest extends BaseTest {
    String expectedErrorEmptyUsername = "Epic sadface: Username is required";
    String expectedErrorEmptyPassword = "Epic sadface: Password is required";
    String lockedUserUsername = "locked_out_user" ;
    String LockedUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
    String invalidUsername = "testUser";
    String invalidPassword = "testPass";
    String invalidUserExpectedError = "Epic sadface: Username and password do not match any user in this service";

    

    
    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage (driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsListPage.verifySuccessfulLogin();
    }
    @Test
    public void verifyEmptyUserNameLogginAttempt(){
        LoginPage loginPage = new LoginPage (driver);

        loginPage.goToBaseUrl ();
        loginPage.login("", validPassword);
        loginPage.verifyUnsuccesfulLogin(expectedErrorEmptyUsername);
        
    }

    @Test
    public void verifyEmptyPasswordLogginAttempt () {
        LoginPage loginPage = new LoginPage (driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, "");
        loginPage.verifyUnsuccesfulLogin(expectedErrorEmptyPassword);

    }
    
    @Test
    public void verifyLockedUserLoginAttempt(){
        LoginPage loginPage = new LoginPage (driver);

        loginPage.goToBaseUrl();
        loginPage.login(lockedUserUsername, validPassword);
        loginPage.verifyUnsuccesfulLogin(LockedUserErrorMessage);
    }
    @Test
    public void verifyInvalidPasswordLoginAttempt(){
        LoginPage loginPage = new LoginPage (driver);

        loginPage.goToBaseUrl();
        loginPage.login (validUsername, invalidPassword);
        loginPage.verifyUnsuccesfulLogin(invalidUserExpectedError);
    }
    @Test
    public void verifyUserLogout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productsListPage.expandMenu();
        productsListPage.navigateToLogin();
        loginPage.verifySuccesfulLogout();
    }
    @Test
    
}
