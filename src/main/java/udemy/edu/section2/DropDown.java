package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://spicejet.com");
        driver.findElement(By.id("ct100_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsct100_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
    }
}
