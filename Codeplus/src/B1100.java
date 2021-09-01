import java.util.Scanner;

public class B1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                a[i][j] = str.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (a[i][j] == 'F') {
                            ans++;
                        }
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        if (a[i][j] == 'F') {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
