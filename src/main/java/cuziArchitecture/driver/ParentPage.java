package cuziArchitecture.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {
    WebDriver driver;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader; // gets cart button

    public ParentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void elementWait(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void elementDisappear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public CartPage goToCartPage() {
        cartHeader.click(); // loads cart page by clicking
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
