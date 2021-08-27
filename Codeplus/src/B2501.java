import java.util.ArrayList;
import java.util.Scanner;

public class B2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                a.add(i);
            }
        }
        if(a.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(a.get(k-1));
        }
    }
}
