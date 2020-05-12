package functional.prg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FlateMapExample {
    public static void main(String[] args) {
        List<String> course = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React");
        List<String> course2 = Arrays.asList("Java", "C++", "Spring", "Spring Boot", "Javascript", "React","AWS","PCF");

        System.out.println(course.stream()
                .collect(Collectors.joining(","))
        );
        System.out.println(Arrays.asList(course.stream().map(cour->cour.split(""))
                .toArray()).toString());

        System.out.println(
                course.stream().map(cour->cour.split(""))
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );

        System.out.println(
                course.stream().map(cour->cour.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList())
        );

        System.out.println(
                course.stream().flatMap(cour->course2.stream().map(cour2->Arrays.asList(cour,cour2))).collect(Collectors.toList())
        );

        System.out.println(
                course.stream().flatMap(cour->course2.stream()
                        .map(cour2->Arrays.asList(cour,cour2)))
                        .filter(list->list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );
        System.out.println(
                course.stream().flatMap(cour->course2.stream()
                        .map(cour2->Arrays.asList(cour,cour2)))
                        .filter(list->!list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );

        System.out.println(
                course.stream().flatMap(cour->course2.stream()
                        .filter(cou2->cou2.length()==cour.length())
                        .map(cour2->Arrays.asList(cour,cour2)))
                        .filter(list->!list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );
    }
}
