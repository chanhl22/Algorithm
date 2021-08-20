import java.util.Scanner;

public class B16985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] a = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    a[i][j][k] = sc.nextInt();
                }
            }
        }

    }
}
