package cuziArchitecture.section2.Miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click(); // click on column
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]")); // capture all web elements into list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList()); // capture texts of all web elements into new (original) list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList()); // sort the original list into sorted list
        Assert.assertTrue(originalList.equals(sortedList)); // compare original and sorted list
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")) // scan the name column with getText -> Beans -> print the priceof the rice
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='next']")).click();
            }
        } while (price.size() < 1);
        driver.close();
        System.out.println("TEST SUCCESS");
    }

    public static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
