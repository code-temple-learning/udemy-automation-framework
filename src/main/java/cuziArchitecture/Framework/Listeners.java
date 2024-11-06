package cuziArchitecture.Framework;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("I successfully executed Listeners pass code");
    }

    public void onTestFailure(ITestResult result) {
        // screenshot code
        // response if API is failed
        System.out.println("I failed to execute Listeners pass code " + result.getName());
    }
}
