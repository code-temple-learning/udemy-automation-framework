package cuziFramework.driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS1 {

    @BeforeMethod
    public void beforeRun() {
        System.out.println("Run this first");
    }

    public void testRun() {
        System.out.println("Running");
    }

    @AfterMethod
    public void afterRun() {
        System.out.println("Run last");
    }
}
