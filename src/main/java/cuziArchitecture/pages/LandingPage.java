package cuziArchitecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ParentPage {
    WebDriver driver;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(id = "login")
    private WebElement submit;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver; //initialization of 'driver'
        PageFactory.initElements(driver, this);// initializes 'FindBy' annotation to get elements
    }

    public void webPage() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductPage loginApplication(String email, String password) {
        userEmail.sendKeys(email); // plugin parameters to methods
        userPassword.sendKeys(password);
        submit.click();
       return new ProductPage(driver);
    }
}
