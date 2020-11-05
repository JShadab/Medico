import java.util.stream.IntStream;

public class Sample {
	public static void main(String[] args) {

		long count = IntStream.of(1, 1, 1).distinct().count();
		 
		System.out.println(count);

	}

}
