import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        String num = Integer.toString(n);
        BigInteger ans = new BigInteger(num);
//        BigInteger ans = BigInteger.valueOf(n);
        while (n-- > 1) {
            ans = ans.multiply(BigInteger.valueOf(n));
        }
        System.out.println(ans);
    }
}

public class H1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result1.extraLongFactorials(n);

        bufferedReader.close();
    }
}
