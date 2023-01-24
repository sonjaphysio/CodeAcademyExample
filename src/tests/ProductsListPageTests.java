package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductsListPage;

public class ProductsListPageTests extends BaseTest {
    int expectedNumberOfProducts = 6;
    @Test
    public void verifyNumberOfProducts(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productPage.verifyNumberOfProducts(expectedNumberOfProducts);
    }
    
}
