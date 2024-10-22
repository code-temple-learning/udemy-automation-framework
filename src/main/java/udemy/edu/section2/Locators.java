package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class Locators {

    static WebDriver driver = new ChromeDriver();
    static String[] userNames = {"rahul", "shetty"};
    static String[] passwordList = {"rahulshettyacademy", "cuzi"};
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(0);
        String username = getUserName(0);
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + username + ",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();
    }
    public static String getPassword(int choosePassword) {
        return passwordList[choosePassword];
    }

    public static String getUserName(int chooseUser) {
        return userNames[chooseUser];
    }
}
