import java.util.*;

public class B3085 {
	static int check(char[][] a) {
		int res = 1;
		for (int i = 0; i < a.length; i++) {
			int count = 1;
			for (int j = 1; j < a.length; j++) {
				if (a[i][j-1] == a[i][j])
					count++;
				else 
					count = 1;
				if (res < count)
					res = count;
			}
			count = 1;
			for (int j = 1; j < a.length; j++) {
				if (a[j-1][i] == a[j][i])
					count++;
				else
					count = 1;
				if (res < count)
					res = count;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j+1 < n) {
					char temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
					int value = check(arr);
					if (res < value)
						res = value;
					temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
				}
				if (i+1 < n) {
					char temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
					int value = check(arr);
					if (res < value)
						res = value;
					temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
				}
			}
		}
		System.out.println(res);
	}
}