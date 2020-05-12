package functional.prg;

import java.util.Arrays;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 45, 34, 31, 81, 15, 145, 34, 40);
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");
//        printCourse(course);
//        printOdd(numbers);
//        printSquareOfNumber(numbers);
//        printOddCube(numbers);
//        printNUmberOfChar(course);
        System.out.println(printSquareCubeSum(numbers));
        System.out.println(printSumEven(numbers));
        System.out.println(printOddSum(numbers));

    }

    private static int printOddSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(x->x%2!=0)
                .reduce(0,Integer::sum);
    }

    private static int printSumEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(x->x%2==0)
                .reduce(0,Integer::sum);
    }

    private static int printSquareCubeSum(List<Integer> numbers) {
//        return  numbers.stream()
//                .map(x->x*x)
//                .reduce(0,Integer::sum);
        return numbers.stream()
                .map(x -> x * x * x)
                .reduce(0, Integer::sum);

    }

    private static void printNUmberOfChar(List<String> course) {
        course.stream()
                .map(str -> str + "  " + str.length())
                .forEach(System.out::println);
    }

    private static void printSquareOfNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(num -> num * num)
                .forEach(System.out::println);
    }

    private static void printCourse(List<String> course) {
        course.stream().forEach(System.out::println);
        course.stream()
                .filter(str -> str.contains("Spring"))
                .forEach(System.out::println);

        System.out.println("Length Greater than or equal to 4");
        System.out.println();

        course.stream()
                .filter(str -> str.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printOdd(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);

    }

    private static void printOddCube(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);

    }


}
