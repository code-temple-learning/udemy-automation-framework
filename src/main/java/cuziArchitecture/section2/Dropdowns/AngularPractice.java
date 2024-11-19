package cuziArchitecture.section2.Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AngularPractice {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("cuzi");
        driver.findElement(By.name("email")).sendKeys("xsin@sexmail.org");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("greyFox");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement options = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(options);
        dropdown.selectByIndex(1);
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("02/25/1994");
        driver.findElement(By.cssSelector(".btn-success")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
