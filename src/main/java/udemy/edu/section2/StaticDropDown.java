package udemy.edu.section2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println("WAITING FOR WEBPAGE TO LOAD");
        Thread.sleep(4000);
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        System.out.println("INTERACTING WITH DROPDOWN");
        Thread.sleep(3000);
        Select dropdown = new Select(staticDropdown);
        Thread.sleep(2000);
        System.out.println("INDEX 3 SELECTED");
        dropdown.selectByIndex(1);
        Thread.sleep(4000);
        driver.close();
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByVisibleText("AED");
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByValue("INR");
//        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}
