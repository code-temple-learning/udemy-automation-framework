package CuziTestArchitecture.learnTests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayTwoTests {

    @Parameters ({"URL", "APIKey/username"})
    @Test
    public void personalLoanTest(String webName, String key) {
        System.out.println("good");
        System.out.println(webName);
        System.out.println(key);
    }
}
