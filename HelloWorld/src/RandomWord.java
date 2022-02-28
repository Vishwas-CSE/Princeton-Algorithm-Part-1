import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

	public static void main(String[] args) {
		StdRandom.setSeed(1234);
		StdRandom.shuffle(args);
		System.out.println(args);

	}

}
