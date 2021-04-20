import java.util.*;

public class B10819 {

	static int calculate(int[] a) {
		int sum = 0;
		for (int i = 1; i < a.length; i++) {
			sum += Math.abs(a[i-1] - a[i]);
		}
		return sum;
	}
	
	static boolean next(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i-1] >= a[i]) {
			i--;
		}
		if (i <= 0) return false;
		 
		int j = a.length - 1;
		while (a[i-1] >= a[j]) {
			j--;
		}
		
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length - 1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int ans = 0;
		do {
			int sum = calculate(a);
			ans = Math.max(ans, sum);
		}while(next(a));
		System.out.println(ans);
	}

}
