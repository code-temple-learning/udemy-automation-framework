package browsertests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

    @Parameters({"URL"})
    @Test(priority = 2)
    public void WebLoginCarLoan(String urlName) {
        System.out.println("hello world");
        System.out.println(urlName);
    }

    @Test(priority = 3)
    public void MobileLoginCarLoan() {
        System.out.println("hello world");
    }

    @Test
    public void MobileSignInCarLoan() {
        System.out.println("Mobile sign-in car loan");
    }

    @Test
    public void MobileSignOutCarLoan() {
        System.out.println("Mobile sign-out car loan");
    }

    @DataProvider
    public Object[][] GetData() {
        Object[][] data = new Object[3][2];
        //1st array - user/pass - good credit history
        data[0][0] = "username";
        data[0][1] = "password";
        //2nd array - user/pass - no credit
        data[1][0] = "username1";
        data[1][1] = "password1";
        //3rd array - user/pass - fraud credit
        data[2][0] = "username2";
        data[2][1] = "password2";
        return data;
    }

    @Test(priority = 1)
    public void APILoginCarLoan() {
        System.out.println("hello world");
    }



}
