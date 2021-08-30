import java.util.Scanner;

public class B11170 {
    static int cal(int n, int m) {
        int ans = 0;
        for (int num = n; num <= m; num++) {
            if (num == 0) {
                ans++;
            }
            int temp = num;
            while (temp > 0) {
                if (temp % 10 == 0) {
                    ans++;
                }
                temp = temp / 10;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = 0;
            ans += cal(n,m);
            System.out.println(ans);
        }
    }
}
