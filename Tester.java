
public class Tester {
	public static void main(String arg[]) {
		int max = 5, min = 1;
		int n;// (int) (Math.random() * (max - min) + min + 1);
		for (int i = 0; i < 25; i++) {
			n = (int) (Math.random() * (max - min + 1) + min);
			System.out.println(n);
			
		}

	}

}
