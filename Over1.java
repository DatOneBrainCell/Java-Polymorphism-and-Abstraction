public class Over1 {
    public static void main(String[] args) {
        Cl3 cl = new Cl3();
    }
}
class Cl1 {
    Cl1() {
        System.out.println("This is the first Constructor");
    }
}
class Cl2 extends Cl1 {
    Cl2() {
        super();
        System.out.println("This is the second Constructor");
    }
}
class Cl3 extends Cl2 {
    Cl3() {
        this(1);
        System.out.println("This is the third Constructor");
    }
    Cl3(int n) {
        System.out.println("'This' keyword: " + n);
    }
}
