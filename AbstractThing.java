public class AbstractThing {
    public static void main(String[] args) {
        BaseClass d1 = new Der1();
        BaseClass d2 = new Der2();
        BaseClass d3 = new Der3();
        
        d1.PrintSmth();
        d2.PrintSmth();
        d3.PrintSmth();
    }
}
abstract class BaseClass {
    abstract void PrintSmth();
}
class Der1 extends BaseClass {
    @Override
    void PrintSmth() {
        System.out.println("Something");
    }
}
class Der2 extends BaseClass {
    @Override
    void PrintSmth() {
        System.out.println("Not something");
    }
}
class Der3 extends BaseClass {
    @Override
    void PrintSmth() {
        System.out.println("Definitely not something");
    }
}
