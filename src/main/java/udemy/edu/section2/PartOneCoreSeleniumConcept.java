package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class PartOneCoreSeleniumConcept {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // this will fail the test immediately because of incorrect username and password
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("cuzi");
        driver.findElement(By.name("inputPassword")).sendKeys("shadowMoses");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        // incorrect steps in test case due to earlier statements above this one
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("AntDizzle");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("kaurlll@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("tortaPounder@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9877863778");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);

        // not working because of earlier code statements that provide incorrect username and password attempts
        // this has the correct credentials
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
    }

}
