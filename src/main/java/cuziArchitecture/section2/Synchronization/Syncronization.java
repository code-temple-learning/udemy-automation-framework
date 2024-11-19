package cuziArchitecture.section2.Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Syncronization {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
//        selectDropdownByIndex(By.xpath("//select[@class='form-control']"), 3);
        WebElement options = driver.findElement(By.xpath("//select[@class='form-control']")); // xpath validated through chrome devtools $x(//select[@class='form-control'])
        Select dropdown = new Select(options);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Check out")));
        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer.btn-info"));
        for (int i = 0; i < products.size(); i++) {
            products.get(i).click();
        }
        driver.findElement(By.partialLinkText("Checkout")).click();
        System.out.println("TEST SUCCESS");
        driver.close();
    }

//    public static void selectDropdownByIndex(By locator, int dropdownOptions) {
//         //select[@class='form-control']/option[3]
//        WebElement elementLocator = driver.findElement(locator);
//        Select options = new Select(elementLocator);
//        options.selectByIndex(dropdownOptions);
//    }
}
