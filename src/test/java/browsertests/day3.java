package browsertests;

import org.testng.annotations.Test;

public class day3 {

    @Test(priority = 2)
    public void WebLoginCarLoan() {
        System.out.println("hello world");
    }

    @Test(priority = 3)
    public void MobileLoginCarLoan() {
        System.out.println("hello world");
    }

    @Test(priority = 1)
    public void APILoginCarLoan() {
        System.out.println("hello world");
    }
}
