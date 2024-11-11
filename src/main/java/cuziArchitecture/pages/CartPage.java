package cuziArchitecture.pages;

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
        System.out.println("compares product text");
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        System.out.println("returns product name");
        return match;
    }

    public CheckoutPage goToCheckout() {
        System.out.println("clicks checkout button");
        checkoutEle.click();
        System.out.println("moves to checkout page");
        return new CheckoutPage(driver);
    }
}
