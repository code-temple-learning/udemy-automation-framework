package cuziArchitecture.section2.Scope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {

    public static void main(String[] args) {
        String month = "2";
        String day = "25";
        String year = "2024";
        String[] list = {month, day, year};
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='" + day +"']")).click();
        List<WebElement> date = driver.findElements(By.cssSelector("react-date-picker__inputGroup__input"));
        for (int i = 0; i < date.size(); i++) {
            System.out.println(date.get(i).getAttribute("value"));
            Assert.assertEquals(date.get(i).getAttribute("value"), list[i]);
        }
        driver.close();
        System.out.println("TEST SUCCESS");
    }
}
