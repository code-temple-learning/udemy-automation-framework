package cuziArchitecture.pages;

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
    private WebElement cartHeader; // gets cart button

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
        System.out.println("clicks go to cart button");
        cartHeader.click(); // loads cart page by clicking
        System.out.println("cart button clicked");
        return new CartPage(driver);
    }
}
