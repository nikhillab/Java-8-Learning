package functional.prg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int noOfStudent;
    private int reviewScore;

    public Course(String name, String category, int reviewScore, int noOfStudent) {
        this.name = name;
        this.category = category;
        this.noOfStudent = noOfStudent;
        this.reviewScore = reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", category='" + category + '\'' +
                        ", noOfStudent=" + noOfStudent +
                        ", reviewScore=" + reviewScore + "|";
    }
}

public class CustomClass {
    public static void main(String[] args) {
        List<Course> course = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> reviewScore = cour -> cour.getReviewScore() > 90;

        System.out.println(course.stream().allMatch(reviewScore));
        System.out.println(course.stream().allMatch(cour -> cour.getNoOfStudent() > 95));
        System.out.println(course.stream().anyMatch(cour -> cour.getNoOfStudent() > 95));
        System.out.println(course.stream().noneMatch(cour -> cour.getNoOfStudent() > 95));

        Comparator<Course> comparator = Comparator.comparing(Course::getNoOfStudent);

        Comparator<Course> comparatorDecresing = Comparator.comparing(Course::getNoOfStudent).reversed();

        List<Course> sortedCourseIncreasing = course.stream()
                .sorted(comparator).collect(Collectors.toList());
        System.out.println(sortedCourseIncreasing);

        List<Course> sortedCourseDecreasing = course.stream()
                .sorted(comparatorDecresing).collect(Collectors.toList());
        System.out.println(sortedCourseDecreasing);

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudent).thenComparingInt(Course::getReviewScore).reversed();
        List<Course> UsingNoOfStudentAndReviw = course.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList());
        System.out.println(UsingNoOfStudentAndReviw);

        System.out.println(
                course.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList()));
        System.out.println(
                course.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList()));


        System.out.println(
                course.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList()));

        System.out.println(
                course.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews).get());

        System.out.println(
                course.stream()
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));


        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .findFirst());

        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .findAny());

        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .mapToInt(Course::getNoOfStudent)
                        .sum());
        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .mapToInt(Course::getNoOfStudent)
                        .average().getAsDouble());

        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .mapToInt(Course::getNoOfStudent)
                        .count());

        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .mapToInt(Course::getNoOfStudent)
                        .max().getAsInt());

        System.out.println(
                course.stream()
                        .filter(reviewScore)
                        .mapToInt(Course::getNoOfStudent)
                        .min().getAsInt());

        System.out.println(course.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(course.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println(course.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        System.out.println(
                course.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));


    }
}
