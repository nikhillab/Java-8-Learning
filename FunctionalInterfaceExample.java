package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaceExample {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 6, 4, 8, 9, 7, 10, 12, 15);

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer, Integer> IntegerFunction = num -> num * num;

        Consumer<Integer> consumerSupplier = System.out::println;

        final BinaryOperator<Integer> sum1 = Integer::sum;
        final UnaryOperator<Integer> unaryOperator = (x) -> 10 * x;

        Supplier<Integer> randomInt = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println("Supplier");
        System.out.println(randomInt.get());

        System.out.println("Predicate Consumer Function");
        numbers.stream()
                .filter(isEven)
                .map(IntegerFunction)
                .forEach(consumerSupplier);

        System.out.println("UnaryOperator");
        System.out.println(unaryOperator.apply(5));

        int sum = numbers.stream()
                .reduce(0, sum1);

        System.out.println("Sum is " + sum);

    }

}
