import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next().toCharArray();			
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println(arr[i][j]);				
			}
		}
	}
}
