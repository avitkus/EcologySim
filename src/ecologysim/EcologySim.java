package ecologysim;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EcologySim {

	public static void main(String[] args) {
		IntStream.range(0, 10).mapToObj(i->(int)i).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.shuffle(list);
			return list;
		})).stream().limit(5).forEach(System.out::println);
	}

}
