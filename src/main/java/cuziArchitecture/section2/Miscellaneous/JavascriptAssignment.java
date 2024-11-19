package cuziArchitecture.section2.Miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavascriptAssignment {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement content = driver.findElement(By.id("product"));
        System.out.println(content.findElements(By.tagName("tr")).size());
        System.out.println(content.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> rows = content.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
        System.out.println(rows.get(0).getText());
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
