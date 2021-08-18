import java.util.*;
public class B15655 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];
    static StringBuilder go(int index, int start, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(num[a[i]]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=start; i<n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            ans.append(go(index+1, i+1, n, m));
            c[i] = false;
        }
        return ans;
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        System.out.print(go(0,0,n,m));
    }
}

//import java.util.*;
//public class Main {
//    static int[] a = new int[10];
//    static int[] num = new int[10];
//    static StringBuilder go(int index, int selected, int n, int m) {
//        if (selected == m) {
//            StringBuilder sb = new StringBuilder();
//            for (int i=0; i<m; i++) {
//                sb.append(num[a[i]]);
//                if (i != m-1) sb.append(" ");
//            }
//            sb.append("\n");
//            return sb;
//        }
//        StringBuilder ans = new StringBuilder();
//        if (index >= n) return ans;
//        a[selected] = index;
//        ans.append(go(index+1, selected+1, n, m));
//        a[selected] = 0;
//        ans.append(go(index+1, selected, n, m));
//        return ans;
//    }   
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            num[i] = sc.nextInt();
//        }
//        Arrays.sort(num, 0, n);
//        System.out.print(go(0,0,n,m));
//    }
//}