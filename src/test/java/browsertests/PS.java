package browsertests;

import cuziFramework.driver.PS1;
import cuziFramework.driver.PS2;
import org.testng.annotations.Test;

public class PS extends PS1 {

    @Test
    public void test() {
        PS2 ps2 = new PS2(3);
        int a = 3;
        testRun();
        System.out.println(ps2.increment());
        System.out.println(ps2.decrement());
        System.out.println(ps2.multiply1());
    }
}
