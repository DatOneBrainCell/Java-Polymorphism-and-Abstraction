class Dragon {
	void Species() {
		System.out.println("This is a Dragon");
	}
}
class Wyvern extends Dragon {
	@Override
	public void Species() {
		System.out.println("This is a Wyvern");
	}
}
class Drake extends Dragon {
	@Override
	public void Species() {
		System.out.println("This is a Drake");
	}
}
public class Creatures {
	public static void main(String [] args) {
		Dragon[] dragons = new Dragon[2];
		
		dragons[0] = new Wyvern();
		dragons[1] = new Drake();

		dragons[0].Species();
		dragons[1].Species();
	}
}
