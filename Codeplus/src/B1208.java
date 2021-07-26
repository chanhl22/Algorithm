import java.util.Arrays;
import java.util.Scanner;

public class B1208 {
    static int[] a;
    static int[] first;
    static int[] second;
    static int k1 = 0;
    static int k2 = 0;
    static int n;
    static int m;

    static void go1(int index, int sum) {
        if (index == n) {
            first[k1] = sum;
            k1++;
            return;
        }
        go1(index + 1, sum + a[index]);
        go1(index + 1, sum);
    }

    static void go2(int index, int sum) {
        if (index + n == n + m) {
            second[k2] = sum;
            k2++;
            return;
        }
        go2(index + 1, sum + a[index + n]);
        go2(index + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int s = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        m = n / 2;
        n = n - m;
        first = new int[(int) Math.pow(2, n)];
        go1(0, 0);
        second = new int[(int) Math.pow(2, m)];
        go2(0, 0);

        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < ((int) Math.pow(2, m)) / 2; i++) {
            int temp = second[i];
            second[i] = second[(int) Math.pow(2, m) - 1 - i];
            second[(int) Math.pow(2, m) - 1 - i] = temp;
        }

        n = (int) Math.pow(2, n);
        m = (int) Math.pow(2, m);
        int left = 0;
        int right = 0;
        long ans = 0;
        while (left < n && right < m) {
            if (first[left] + second[right] == s) {
                long c1 = 1;
                long c2 = 1;
                left += 1;
                right += 1;
                while (left < n && first[left] == first[left - 1]) {
                    c1 += 1;
                    left += 1;
                }
                while (right < m && second[right] == second[right - 1]) {
                    c2 += 1;
                    right += 1;
                }
                ans += c1 * c2;
            } else if (first[left] + second[right] < s) {
                left += 1;
            } else if (first[left] + second[right] > s) {
                right += 1;
            }
        }
        if (s == 0) ans -= 1;
        System.out.println(ans);
    }
}
