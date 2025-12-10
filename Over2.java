public class Over2 {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        Wyvern wyvern = new Wyvern();
        Drake drake = new Drake();
        
        dragon.NoOfLegs();
        dragon.NoOfWings();
        
        System.out.println();
        
        wyvern.NoOfLegs();
        wyvern.NoOfWings();
        
        System.out.println();
        
        drake.NoOfLegs();
        drake.NoOfWings();
        
        System.out.println();
    }
}
class Dragon {
    String name = new String("Dragon");
    public void NoOfWings() {
        System.out.println(name + "s have two wings");
    }
    public void NoOfLegs() {
        System.out.println(name + "s have four legs");
    }
}
class Wyvern extends Dragon {
    String name = new String("Wyvern");
    @Override
    public void NoOfWings() {
        super.NoOfWings();
    }
    public void NoOfLegs() {
        System.out.println(name + "s have two legs");
    }
}
class Drake extends Dragon{
    String name = new String("Drake");
    public void NoOfWings() {
        System.out.println(name + "s have no wings");
    }
    @Override
    public void NoOfLegs() {
        super.NoOfLegs();
    }
}
