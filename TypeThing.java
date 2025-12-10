class TypeProg {
	public int Add(int a, int b) {
		return a + b;
	}
	public float Add(float a, float b) {
		return a + b;
	}
	public long Add(long a, long b) {
		return a + b;
	}
	public double Add(double a, double b) {
		return a + b;
	}
}

public class TypeThing {
	public static void main(String[] args) {

		TypeProg tp = new TypeProg();

		int a = 5, b = 7;
		System.out.println("Int: " + tp.Add(a, b));

		float c = 4.2f, d = 7.5f;
		System.out.println("Float: " + tp.Add(c, d));

		long e = 593012, f = 3924827;
		System.out.println("Long: " + tp.Add(e, f));

		double g = 5.238713, h = 72193.4532123213;
		System.out.println("Double: " + tp.Add(g, h));
	}
}
