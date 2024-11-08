package CuziTestArchitecture.browsertests.learnTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayTwo {

    @Parameters ({"URL", "APIKey/username"})
    @Test
    public void personalLoan(String webName, String key) {
        System.out.println("good");
        System.out.println(webName);
        System.out.println(key);
    }
}
