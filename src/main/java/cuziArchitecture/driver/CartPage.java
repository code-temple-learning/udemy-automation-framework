package cuziArchitecture.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends ParentPage {
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    private WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts; // gets list of all items in cart

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout() {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
