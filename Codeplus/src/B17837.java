import java.util.*;


class Piece2 {
	int no;
	int dir;

	Piece2(int no, int dir) {
		this.no = no;
		this.dir = dir;
	}
}

class Pair10 {
	int row;
	int col;
	int index;

	Pair10(int row, int col, int index) {
		this.row = row;
		this.col = col;
		this.index = index;
	}
}

public class B17837 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void go(ArrayList<Piece2>[][] a, Pair10[] where, int x, int y, int nx, int ny, int index) {
		for (int i = index; i < a[x][y].size(); i++) {
			Piece2 p = a[x][y].get(i);
			a[nx][ny].add(p);
			where[p.no] = new Pair10(nx, ny, a[x][y].size() - 1);
		}
		a[x][y] = new ArrayList<>(a[x][y].subList(0, index));
	}

	static int opposite(int dir) {
		if (dir == 0) {
			dir = 1;
		} else if (dir == 1) {
			dir = 0;
		} else if (dir == 2) {
			dir = 3;
		} else if (dir == 3) {
			dir = 2;
		}
		return dir;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] board = new int[n][n];
		ArrayList<Piece2>[][] a = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				a[i][j] = new ArrayList<>();
			}
		}
		Pair10[] where = new Pair10[k];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int dir = sc.nextInt() - 1;
			a[x][y].add(new Piece2(i, dir));
			where[i] = new Pair10(x, y, a[x][y].size() - 1);
		}

		// 1000번까지 이동하고 정답이 없다면 -1
		for (int turn = 1; turn <= 1000; turn++) {
			// 각 말들을 순서대로 이동
			for (int i = 0; i < k; i++) {
				int x = where[i].row;
				int y = where[i].col;
				int index = where[i].index;
				int dir = a[x][y].get(index).dir;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				// 범위안에 들어가지 않으면 파란색과 동일한 취급
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					// 범위 안에 들어가는데 파란색이라면 방향을 반대로
					if (board[nx][ny] == 2) {
						a[x][y].get(index).dir = opposite(dir);
					}
				} else {
					a[x][y].get(index).dir = opposite(dir);
				}
				// 이동하지 않고 현재 위치에서 방향만 바꿨으니까 이동하는 칸으로 좌표와 방향을 새로 만들어줌
				dir = a[x][y].get(index).dir;
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (board[nx][ny] == 0) {
						go(a, where, x, y, nx, ny, index);
					} else if (board[nx][ny] == 1) {
//						List<Piece2> temp = a[x][y].subList(index, a[x][y].size());
						Collections.reverse(a[x][y]);
						go(a, where, x, y, nx, ny, index);
					}
					if (a[nx][ny].size() >= 4) {
						System.out.println(turn);
						System.exit(0);
					}
				} else {
				}
			}
		}
		System.out.println(-1);
	}
}
