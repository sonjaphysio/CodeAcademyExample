package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage {
    
    public ProductsListPage (WebDriver driver) {
        super (driver);
    }

    By pageTitleBy = By.xpath("//span[@class='title']");
    String pageTitle = "PRODUCTS";
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutLinkBy = By.id("logout_sidebar_link");
    By inventoryItemBy = 


    public ProductsListPage verifySuccessfulLogin (){
        String actualPageTitle = readText(pageTitleBy);
        assertTextEquals(pageTitle, actualPageTitle);
        return this;
    }
    public ProductsListPage expandMenu(){
    click(hamburgerMenuBy);
        return this;
    }
    public ProductsListPage navigateToLogin(){
        click(logoutLinkBy);
        return this;
    }
    public ProductsListPage verifyNumberOfProducts (int expectedNumber){
        int actualNumber = countItems(inventoryItemBy);
        assertIntegerEquals(expectedNumber, actualNumber);
        
    }
}
