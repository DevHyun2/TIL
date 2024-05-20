package train;

import java.util.stream.IntStream;

public class 연습장 {

	public static void main(String[] args) {
		
		IntStream a = IntStream.range(1,11);
		
		a.forEach(System.out::println);
		
	}
}
