package functional.prg;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;

public class BiExamples {
    public static void main(String[] args) {
        BiPredicate<Integer, String> biPredicate =
                (number, str) -> number < 10 && str.length() > 5;

        System.out.println(biPredicate.test(10, "nikhil"));

        BiFunction<Integer, String,String>biFunction =
                (number, str) -> number +" "+str;
        System.out.println(biFunction.apply(10,"nikhil"));

        BiConsumer<String, String> biConsumer=
                (str1,str2)-> System.out.println(str1+" "+str2);
        biConsumer.accept("nikhil","kumar");

        IntBinaryOperator intBinaryOperator=(x,y)->x+y;
        System.out.println(intBinaryOperator.applyAsInt(10,20));
    }
}
