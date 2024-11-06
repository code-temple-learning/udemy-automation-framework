package cuziFramework.driver;

public class PS2 extends PS3 {

    int a;

    public PS2(int a) {
        super(a); // a constructor that calls on the constructor of the parent class
        this.a = a;
    }

    public int increment() {
        a = a + 1;
        return a;
    }

    public int decrement() {
        a = a - 1;
        return a;
    }
}
