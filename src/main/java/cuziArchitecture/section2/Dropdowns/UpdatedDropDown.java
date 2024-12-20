package cuziArchitecture.section2.Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

    // TODO Re-review content
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://spicejet.com");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("It's enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        driver.close();
        System.out.println("TEST SUCCESS");
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
//        driver.findElement(By.id("divpaxinfo")).click();
//        Thread.sleep(2000L);
//        for (int i = 1; i < 5; i++) {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }
//        driver.findElement(By.id("btnlosepaxoption")).click();
//        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
//        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}