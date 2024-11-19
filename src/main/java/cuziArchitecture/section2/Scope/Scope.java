package cuziArchitecture.section2.Scope;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size()); // gets the scope of all 'a' elements in the page
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size()); // gets the scope of all 'a' elements in the footer section of page
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size()); // gets the scope of 'a' elements in the column
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // loads each tab under this column in separate pages
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
            Thread.sleep(5000);
        }
            Set<String> window = driver.getWindowHandles();
            Iterator<String> it = window.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
