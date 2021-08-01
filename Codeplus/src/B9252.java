import java.util.Scanner;

public class B9252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        a = " " + a;
        b = " " + b;
        int[][] d = new int[n + 1][m + 1];
        int[][] v = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                    v[i][j] = 1;
                } else {
                    if (d[i - 1][j] > d[i][j - 1]) {
                        d[i][j] = d[i - 1][j]; //아래가 공백
                        v[i][j] = 2;
                    } else {
                        d[i][j] = d[i][j - 1]; //위가 공백
                        v[i][j] = 3;
                    }
                }
            }
        }
        System.out.println(d[n][m]);
        String ans = "";
        while (n > 0 && m > 0) {
            if (v[n][m] == 1){
                ans += a.charAt(n);
                n--;
                m--;
            } else if (v[n][m] == 2) { //아래가 공백이니까 위의 위치를 -1
                n--;
            } else { //위가 공백이니까 아래의 위치를 -1
                m--;
            }
        }
        System.out.println(new StringBuilder(ans).reverse().toString());
    }
}