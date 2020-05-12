package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOnArray {
    public static void main(String[] args) {
        System.out.println(Stream.of(1,2,6,54,1,46,46).count());
        System.out.println(Stream.of(1,2,6,54,1,46,46).reduce(0,Integer::sum));
        int []arr={1,2,6,54,1,46,46};
        System.out.println(Arrays.stream(arr));
        System.out.println(Arrays.stream(arr).count());
        System.out.println(Arrays.stream(arr).average().getAsDouble());
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(arr).min().getAsInt());
        Arrays.stream(arr).filter(num->num%2==0).forEach(System.out::println);
        List<Integer> list = Arrays.stream(arr).filter(num -> num % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(list);


    }
}
