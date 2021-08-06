import java.util.Scanner;

class Tuple1 implements Comparable<Tuple1>{
    int r;
    int c;
    int s;
    int index;

    public Tuple1(int r, int c, int s, int index) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.index = index;
    }

    @Override
    public int compareTo(Tuple1 that) {
        if (this.index > that.index) {
            return 1;
        } else if (this.index == that.index){
            return 0;
        } else {
            return -1;
        }
    }
}

public class B17406 {
    static boolean next_permutation(Tuple1[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1].compareTo(a[i]) >= 0) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length-1;
        while (a[j].compareTo(a[i-1]) <= 0) {
            j -= 1;
        }
        Tuple1 temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Tuple1[] d = new Tuple1[k];
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int s = sc.nextInt();
            d[i] = new Tuple1(r, c, s, i);
        }
        int ans = Integer.MAX_VALUE;
        do {


        }while(next_permutation(d));
    }
}
