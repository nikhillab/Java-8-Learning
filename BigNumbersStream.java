package functional.prg;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class BigNumbersStream {
    public static void main(String[] args) {
        System.out.println(LongStream.rangeClosed(1,20).reduce(1l,(x,y)->x*y));

        System.out.println(
                LongStream.rangeClosed(1,50)
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger.ONE,BigInteger::multiply)
        );

    }
}
