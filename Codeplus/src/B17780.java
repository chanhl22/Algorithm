import java.util.*;

class Piece {
	int no;
	int dir;

	Piece(int no, int dir) {
		this.no = no;
		this.dir = dir;
	}
}

class Pair9 {
	int row;
	int col;

	Pair9(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class B17780 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void go(ArrayList<Piece>[][] a, Pair9[] where, int x, int y, int nx, int ny) {
		for (Piece p : a[x][y]) {
			a[nx][ny].add(p);
			where[p.no] = new Pair9(nx,ny);
		}
		a[x][y].clear();
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
		ArrayList<Piece>[][] a = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				a[i][j] = new ArrayList<>();
			}
		}
		Pair9[] where = new Pair9[k];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int dir = sc.nextInt()-1;
			a[x][y].add(new Piece(i, dir));
			where[i] = new Pair9(x, y);
		}

		// 1000번까지 이동하고 정답이 없다면 -1
		for (int turn = 1; turn <= 1000; turn++) {
			// 각 말들을 순서대로 이동
			for (int i = 0; i < k; i++) {
				int x = where[i].row;
				int y = where[i].col;
				// 이동할 때 bottom의 숫자가 이동하려는 말의 번호와 일치한다면 이동!
				if (a[x][y].get(0).no == i) {
					int dir = a[x][y].get(0).dir;
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					// 범위안에 들어가지 않으면 파란색과 동일한 취급
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						// 범위 안에 들어가는데 파란색이라면 방향을 반대로
						if (board[nx][ny] == 2) {
							a[x][y].get(0).dir = opposite(dir);
						}
					} else {
						a[x][y].get(0).dir = opposite(dir);
					}
					// 이동하지 않고 현재 위치에서 방향만 바꿨으니까 이동하는 칸으로 좌표와 방향을 새로 만들어줌
					dir = a[x][y].get(0).dir;
					nx = x + dx[dir];
					ny = y + dy[dir];
					// 다시 범위를 체크해줘야하는데 방향을 바꾸고 이동하는데 또 체스판 밖으로 넘어갈 수 있기 때문이다.
					// 그림으로 나와있는 문제 예시 말 4번을 보면 이해가 된다.
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						// 흰
						if (board[nx][ny] == 0) {
							go(a, where, x, y, nx, ny);
						// 빨
						} else if (board[nx][ny] == 1) {
							Collections.reverse(a[x][y]);
							go(a, where, x, y, nx, ny);
						}
						if (a[nx][ny].size() >= 4) {
							System.out.println(turn);
							System.exit(0);
						}
					} else {
					}
				}
			}
		}
		System.out.println(-1);
	}
}
