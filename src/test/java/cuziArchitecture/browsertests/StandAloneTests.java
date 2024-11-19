package cuziArchitecture.browsertests;

import CuziTestArchitecture.UiTests.baseTest.BaseTests;
import cuziArchitecture.pages.CartPage;
import cuziArchitecture.pages.CheckoutPage;
import cuziArchitecture.pages.ConfirmationPage;
import cuziArchitecture.pages.ProductPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class StandAloneTests extends BaseTests {

    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getDataTest")
    public void standAloneTest(HashMap<String, String> input) throws IOException {
        ProductPage productPage = landingPage.loginApplication(input.get("email"), input.get("password"));
        productPage.addProductToCart(input.get("product"));
        CartPage cartPage = productPage.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));// compares variable 'confirmMessage' to the text to confirm assertion is true
    }

    @DataProvider
    public Object[][] getDataTest() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "tjeffy@yahoo.com");
        map.put("password", "Yahoo97!");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "jeffyt@yahoo.com");
        map1.put("password", "Yahoo97!");
        map1.put("product", "ZARA COAT 3");
        return new Object[][]{{map}, {map1}};
    }
}
