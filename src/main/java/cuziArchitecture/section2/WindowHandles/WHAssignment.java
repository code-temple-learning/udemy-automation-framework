package cuziArchitecture.section2.WindowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WHAssignment {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        driver.switchTo().window(it.next());
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
