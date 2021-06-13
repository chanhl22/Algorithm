import java.util.*;
import java.util.Map.Entry;

class Pair8 implements Comparable<Pair8>{
	int num, cnt;
    Pair8(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
    public int compareTo(Pair8 that) {
    	if (this.cnt < that.cnt) {
    		return -1;
    	}
    	else if(this.cnt == that.cnt){
    		if (this.num < that.num) {
    			return -1;
    		}
    		else if(this.num == that.num) {
    			return 0;
    		}
    		else {
    			return 1;
    		}
    	}
    	else {
    		return 1;
    	}
    }
}

public class B17140 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int k = sc.nextInt();
		int[][] a = new int[100][100];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		if (a[r][c] == k) {
			System.out.println(ans);
			System.exit(0);
		}
		
		int m = 3; 
		int n = 3;
		for (int t = 1; t <= 100; t++) {
			if (n >= m) {
				int mm = m;
				for (int i = 0; i < n; i++) {
					//HashMap으로 각각의 수와 각각의 수의 등장 횟수를 구해서 집어넣는다.
					HashMap<Integer, Integer> d = new HashMap<>();
					for (int j = 0; j < m; j++) {
						if (a[i][j] == 0) continue;
						int val = 0;
						//만약 이전에 구한 key(각각의 수)가 있다면 value(등장 횟수)를 val변수에 넣는다.
						if (d.containsKey(a[i][j])) {
							val = d.get(a[i][j]);
						}
						val += 1;
						d.put(a[i][j], val);
					}
					//정렬을 하기 위해 ArrayList를 만들고 ArrayList를 정렬한다. 
					ArrayList<Pair8> v = new ArrayList<>();
					for(Entry<Integer, Integer> entry : d.entrySet()) {
						v.add(new Pair8(entry.getKey(), entry.getValue()));
					}
					Collections.sort(v);
					// 100보다 크면 잘랴아하는데 HashMap이므로 2개의 쌍이니 50보다 크면 자른다.
					int l = Math.min(v.size(), 50);
					// a배열에 HashMap에서 구한 key,value를 넣는다.
					for (int j = 0; j < l; j++) {
						a[i][j*2] = v.get(j).num;
						a[i][j*2+1] = v.get(j).cnt;
					}
					// 만약 l이 50보다 작을 때 0으로 채워야한다. 
					for (int j = l*2; j < 100; j++) {
						a[i][j] = 0;
					}
					// 바뀐 a배열에서 행의 개수와 열의 개수를 다시 비교해서 연산을 반복해야하니까 m값을 구한다.
					if (mm < v.size()*2) {
						mm = v.size()*2;
					}
				}
				m = mm;
			}
			else {
				int nn = n;
				for (int j = 0; j < m; j++) {
					//HashMap으로 각각의 수와 각각의 수의 등장 횟수를 구해서 집어넣는다.
					HashMap<Integer, Integer> d = new HashMap<>();
					for (int i = 0; i < n; i++) {
						if (a[i][j] == 0) continue;
						int val = 0;
						//만약 이전에 구한 key(각각의 수)가 있다면 value(등장 횟수)를 val변수에 넣는다.
						if (d.containsKey(a[i][j])) {
							val = d.get(a[i][j]);
						}
						val += 1;
						d.put(a[i][j], val);
					}
					//정렬을 하기 위해 ArrayList를 만들고 ArrayList를 정렬한다. 
					ArrayList<Pair8> v = new ArrayList<>();
					for(Entry<Integer, Integer> entry : d.entrySet()) {
						v.add(new Pair8(entry.getKey(), entry.getValue()));
					}
					Collections.sort(v);
					// 100보다 크면 잘랴아하는데 HashMap이므로 2개의 쌍이니 50보다 크면 자른다.
					int l = Math.min(v.size(), 50);
					// a배열에 HashMap에서 구한 key,value를 넣는다.
					for (int i = 0; i < l; i++) {
						a[i*2][j] = v.get(i).num;
						a[i*2+1][j] = v.get(i).cnt;
					}
					// 만약 l이 50보다 작을 때 0으로 채워야한다. 
					for (int i = l*2; i < 100; i++) {
						a[i][j] = 0;
					}
					// 바뀐 a배열에서 행의 개수와 열의 개수를 다시 비교해서 연산을 반복해야하니까 m값을 구한다.
					if (nn < v.size()*2) {
						nn = v.size()*2;
					}
				}
				n = nn;
			}
			if (a[r][c] == k) {
                System.out.println(t);
                System.exit(0);
            }
		}
		System.out.println(-1);
	}

}