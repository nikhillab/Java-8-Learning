package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectResult {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 45, 34, 31, 81, 15, 145, 34, 40);
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");
        doubleList(numbers).stream()
                .forEach(System.out::println);

        evenList(numbers).stream()
                .forEach(System.out::println);
        oddList(numbers).stream()
                .forEach(System.out::println);

        lengthOfCourse(course).stream()
                .forEach(System.out::println);
    }

    private static List<Integer> lengthOfCourse(List<String> course) {
        return course.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());
    }

    private static List<Integer> oddList(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }


}
