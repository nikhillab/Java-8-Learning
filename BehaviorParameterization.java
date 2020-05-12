package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 6, 4, 8, 9, 7, 10, 12, 15);
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;

        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        Function<Integer, Integer> integerFunction = x -> x * x;



        System.out.println("evenPredicate");
        printWithPredicate(numbers, evenPredicate);

        System.out.println("oddPredicate");
        printWithPredicate(numbers, oddPredicate);

        System.out.println("divisible by 3");
        printWithPredicate(numbers, x -> x % 3 == 0);

        System.out.println("printWithFunction");
        //printWithFunction(numbers, integerFunction);
        System.out.println(printWithFunction(numbers, x->x*x));


    }

    private static void printWithPredicate(List<Integer> numbers, Predicate<Integer> oddPredicate) {
        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);
    }

    private static List<Integer> printWithFunction(List<Integer> numbers, Function<Integer, Integer> integerFunction) {
      return  numbers.stream()
                .map(integerFunction)
                .collect(Collectors.toList());
               // .forEach(System.out::println);
    }

}
