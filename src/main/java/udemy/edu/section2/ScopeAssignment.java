package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScopeAssignment {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("checkBoxOption2")).click();
        String opt2 = driver.findElement(By.id("checkBoxOption2")).getText();
        WebElement options = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(options);
        dropdown.selectByVisibleText(opt2);
        driver.findElement(By.id("name")).sendKeys(opt2);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if (text.contains(opt2)) {
            System.out.println("Hello Option2, share this practice page and share your knowledge");
        } else {
            System.out.println("Message was unsuccessful");
        }
        System.out.println(driver.findElement(By.id("checkBoxOption2")).getText());
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
