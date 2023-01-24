package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }
    
    String baseUrl = "https://www.saucedemo.com/";
    By usernameBy = By.id ("user-name");
    By passwordBy = By.id ("password");
    By loginButtonBy = By.id ("login-button");
    By errorFieldBy = By.xpath ("//h3[@data-test='error']");
    
    public LoginPage goToBaseUrl(){
        driver.get (baseUrl);
        return this;
    }

    public LoginPage login (String username, String password) {
        writeText (usernameBy, username);
        writeText (passwordBy, password);
        click (loginButtonBy);
        return this;
    }
    public LoginPage verifyUnsuccesfulLogin(String expectedError){
        String actualText = readText (errorFieldBy);
        assertTextEquals(actualText, expectedError);
        return this;
    }
    public LoginPage verifySuccesfulLogout (){
        assertElementVisible(loginButtonBy);
        return this;
    }
    
}