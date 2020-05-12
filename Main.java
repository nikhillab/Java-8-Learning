package functional.prg;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        printAllNumberInListStruct(Arrays.asList(12, 6, 511, 55, 454, 5, 546, 1654));
        printAllNumberInListFunctional(
                Arrays.asList(12, 6, 511, 55, 454, 5, 546, 1654)
        );

    }

    private static void printAllNumberInListFunctional(List<Integer> number) {
        number.stream().forEach(Main::print);

        number.stream().forEach(System.out::println);

        number.stream()
                .filter(Main::isEven)
                .forEach(System.out::println);


        number.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printAllNumberInListStruct(List<Integer> numbers) {
        for (int num : numbers) {
            System.out.println(num);
        }
        for (int num : numbers) {
            if (num % 2 == 0)
                System.out.println(num);
        }
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
