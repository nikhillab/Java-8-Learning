package functional.prg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesExample {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("C:\\Users\\nikhil\\IdeaProjects\\javafunctional\\src\\main\\java\\functional\\prg\\JShell.txt"))
                    .map(str->str.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

            Files.list(Paths.get("."))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
