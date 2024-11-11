package CuziTestArchitecture.UiTests.baseTest;

import cuziArchitecture.driver.WebDriverFactory;
import cuziArchitecture.pages.LandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTests extends WebDriverFactory {

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        System.out.println("calls LandingPage");
        landingPage = new LandingPage(driver);
        landingPage.webPage();
        System.out.println("LandingPage called");
        return landingPage;
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("TEST SUCCESS");
    }

}
