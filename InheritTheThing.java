public class InheritTheThing {
    public static void main(String[] args) {
        MultipleInherit mi = new MultipleInherit();
        
        mi.Display();
        mi.Write();
    }
}
interface Smth {
    void Display();
}
interface SmthElse {
    void Write();
}
class MultipleInherit implements Smth, SmthElse {
    @Override
    public void Display() {
        System.out.println("Hello!!!!!!!");
    }
    @Override
    public void Write() {
        System.out.println("Something");
    }
}
