package functional.prg;

import java.util.Arrays;
import java.util.List;

public class Section2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 45, 34, 31, 81, 15, 145, 34, 40, 2, 45, 34);
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");

        int sum1 = addListStruct(numbers);
        int sum2 = addListFunction(numbers);
        System.out.println(sum1);
        System.out.println(sum2);
        numbers.stream().distinct().forEach(System.out::println);
        numbers.stream().sorted().forEach(System.out::println);
        numbers.stream()
                .distinct().sorted()
                .forEach(System.out::println);
        course.stream()
                .sorted()
                .forEach(System.out::println);


    }

    private static int addListFunction(List<Integer> numbers) {
//        return numbers.stream()
//                .reduce(0,Section2::sum);
//        return numbers.stream()
//                .reduce(0,(x,y)->x+y);
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static Integer sum(Integer integer, Integer integer1) {
        System.out.println(integer + "  " + integer1);
        return integer + integer1;
    }

    private static int addListStruct(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers)
            sum = sum + num;
        return sum;
    }
}
