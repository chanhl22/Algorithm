import java.util.*;

public class B6603 {
	static int n;
	static boolean[] c;
	static int[] a;
	
	static void go(int index, int start) {
		if (index == 6) {
			for (int i = 0; i < n; i++) {
				if (c[i]) {
					System.out.print(a[i] + " ");					
				}
			}
			System.out.println();
		}
		
		for (int i = start; i < n; i++) {
			c[i] = true;
			go(index+1, i+1);
			c[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true){
            n = sc.nextInt();
 
            if(n==0){
                break;
            }
            a = new int[n];
            c = new boolean[n];
            for (int i = 0; i <n ; i++) {
                a[i] = sc.nextInt();
            }
 
            go(0, 0);
            System.out.println();
		}
	}
}
