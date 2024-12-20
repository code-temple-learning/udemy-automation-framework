package cuziArchitecture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends ParentPage {
    WebDriver driver;

    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationMessage() {
        System.out.println("confirmation message displayed");
        return confirmationMessage.getText();
    }
}
