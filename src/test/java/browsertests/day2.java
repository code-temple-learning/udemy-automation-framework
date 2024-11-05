package browsertests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {

    @Parameters ({"URL, APIKey/username"})
    @Test
    public void PersonalLoan(String webName, String key) {
        System.out.println("good");
        System.out.println(webName);
        System.out.println(key);
    }
}
