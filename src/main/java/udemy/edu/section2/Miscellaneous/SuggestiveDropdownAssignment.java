package udemy.edu.section2.Miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuggestiveDropdownAssignment {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("bri");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
