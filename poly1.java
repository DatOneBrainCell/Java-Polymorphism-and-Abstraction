class Animal {
	void Who() {
		System.out.println("I am an Animal");
	}
}
class Dog extends Animal {
	@Override
	public void Who() {
		System.out.println("I am a Dog");
	}
}
class Cat extends Animal {
	@Override
	public void Who() {
		System.out.println("I am a Cat");
	}
}
class Dragon extends Animal {
	@Override
	public void Who() {
		System.out.println("I am a Dragon");
	}
}
public class Poly1 {
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal dragon = new Dragon();
		
		dog.Who();
		cat.Who();
		dragon.Who();
	}
}
