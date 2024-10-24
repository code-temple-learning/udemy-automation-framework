package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;

public class SeleniumGroceryStore {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String[] items = {"Cucumbers", "Broccoli"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
           String[] name = products.get(i).getText().split("-");
           String name1 = name[0].trim();
           List itemsList = Arrays.asList(items);
           int j = 0;
           if (itemsList.contains(name1)) {
               j++;
               driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
               if (j == items.length) {
                   break;
               }
           }
        }
    }
}
