import java.util.Scanner;

public class B16943 {
    static int n;
    static int[] a;
    static boolean[] check;
    static int b;

    static int go(int index, int num) {
        if (index == n) {
            return num;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            if (index == 0 && a[i] == 0) continue;
            check[i] = true;
            int temp = go(index + 1, num * 10 + a[i]);
            if (temp < b) {
                if (ans == -1 || ans < temp) {
                    ans = temp;
                }
            }
            check[i] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        n = num.length();
        check = new boolean[n];
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = num.charAt(i) - '0';
        }
        b = sc.nextInt();
        System.out.println(go(0, 0));
    }
}
