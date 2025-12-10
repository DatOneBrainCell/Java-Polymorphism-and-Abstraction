public class BaseTest {
    public static void main(String[] args) {
        System.out.println("Calling Derived class:");
        Base der = new Derived();
        der.Hello();
        
        System.out.println("Calling Base class:");
        Base base = new Base();
        base.Hello();
    }
}
class Base {
    public void Hello() {
        System.out.println("Hello");
    }
}
class Derived extends Base {
    @Override
    public void Hello() {
        System.out.println("Not Hello");
    }
}
