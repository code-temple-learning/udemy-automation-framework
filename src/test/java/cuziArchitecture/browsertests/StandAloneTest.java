package cuziArchitecture.browsertests;

import cuziArchitecture.browsertests.basetests.BaseTests;
import cuziArchitecture.pages.CartPage;
import cuziArchitecture.pages.CheckoutPage;
import cuziArchitecture.pages.ConfirmationPage;
import cuziArchitecture.pages.ProductPage;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StandAloneTest extends BaseTests {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData")
    public void standAlone(HashMap<String, String> input) throws IOException {
        ProductPage productPage = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productPage.getProductList();
        productPage.addProductToCart(input.get("product"));
        CartPage cartPage = productPage.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));// compares variable 'confirmMessage' to the text to confirm assertion is true
        System.out.println("TEST SUCCESS");
    }

    @DataProvider
    public Object[][] getData() {
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
