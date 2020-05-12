package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodRefer {
    private static String toUpper(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");

        course.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        course.stream().map(MethodRefer::toUpper).forEach(System.out::println);
        course.stream().map(String::toUpperCase).forEach(System.out::println);

        Supplier<String>stringSupplier=String::new;

    }
}
