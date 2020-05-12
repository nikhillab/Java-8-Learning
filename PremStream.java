package functional.prg;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PremStream {
    public static void main(String[] args) {
       // System.out.println(IntStream.range(1,10).sum());
        //System.out.println(IntStream.rangeClosed(1,10).sum());
//        int sum=IntStream.iterate(1,e->e+2).limit(10).peek(System.out::println).sum();
//        System.out.println(sum);

        IntStream.iterate(2,e->e+2).limit(10).forEach(System.out::println);
        IntStream.iterate(2,e->e*2).limit(10).forEach(System.out::println);
        List<Integer> integerList = IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());
        System.out.println(integerList);

    }
}
