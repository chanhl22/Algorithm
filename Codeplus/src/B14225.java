import java.util.*;

public class B14225 {

	static int[] arr = new int[2000000];
	static int n;
	static int k = 0;
	static int[] a;
	
	static void go(int index, int sum) {
		if(index == n) {
			arr[k] = sum;
			k++;
			return ;
		}
		go (index+1, sum + a[index]);
		go (index+1, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		go(0,0);
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] <= arr[i]) {
				if (!(arr[i-1] + 1 == arr[i] || arr[i-1] == arr[i])) {
					System.out.println(arr[i-1] + 1);
					break;
				}
				if (i == arr.length - 1) {
					System.out.println(arr[i] + 1);
				}
			}
		}
	}

}
