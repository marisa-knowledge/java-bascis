package core_api_02;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class api_demo1 {
    static void main(String[] args) {
        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);


        BigInteger bi = new BigInteger("101");
        BigInteger bi2 = BigInteger.valueOf(10);

        System.out.println(bi.divide(bi2));
        BigInteger[] bigIntegers = bi.divideAndRemainder(bi2);
        System.out.println(bigIntegers[0]);
        System.out.println(bigIntegers[1]);

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));


        System.out.println(a.divide(b,2, BigDecimal.ROUND_HALF_UP));

    }
}
