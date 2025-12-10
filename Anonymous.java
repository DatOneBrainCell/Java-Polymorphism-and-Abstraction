public class Anonymous {
    public static void main(String[] args) {
        Again agn = new Again();
        
        agn.Display();
    }
}
interface Smth {
    void Display();
}
class AnonymousClassThing implements Smth {
    @Override
    public void Display() {
        System.out.println("Hello!!!!!!!");
    }
}
class Again extends AnonymousClassThing {
    public void Display() {
        super.Display();
    }
}
