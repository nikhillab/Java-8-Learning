package functional.prg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompratorStream {
    public static void main(String[] args) {
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");
//            course.stream()
//                    .sorted(Comparator.naturalOrder())
//                    .forEach(System.out::println);
//        course.stream()
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);
        course.stream()
                .sorted(Comparator.comparing(str->str.length()))
                .forEach(System.out::println);
    }
}
