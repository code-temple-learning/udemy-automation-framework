package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://spicejet.com");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnlosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
