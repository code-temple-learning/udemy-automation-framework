package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumGroceryStore {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // explicit wait can catch performance issues, but it takes more code to use
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); implicit wait is cleaner overall for the code, but cannot catch performance issues
        String[] items = {"Cucumbers", "Broccoli"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        addItems(driver, items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.close();
        System.out.println("TEST SUCCESS");
    }

    public static void addItems(WebDriver driver, String[] items) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String name1 = name[0].trim();
            List itemsList = Arrays.asList(items);
            int j = 0;
            if (itemsList.contains(name1)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == items.length) {
                    break;
                }
            }
        }
    }
}
