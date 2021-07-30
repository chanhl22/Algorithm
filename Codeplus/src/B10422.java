import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B10422 {
    static long[] d = new long[5001];
    static long mod = 1000000007L;

    static long go(int n) {
        if (n == 0) {
            return 1;
        }
        if (d[n] != -1) {
            return d[n];
        }
        d[n] = 0;
        for (int i = 2; i <= n; i += 2) {
            d[n] += go(i - 2) * go(n - i);
            d[n] %= mod;
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        ;
        while (t-- > 0) {
            int l = sc.nextInt();
            if (l % 2 == 0) {
                System.out.println(go(l));
            } else {
                System.out.println(0);
            }
        }
    }
}
