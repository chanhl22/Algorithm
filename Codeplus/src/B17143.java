import java.util.Scanner;

class Fish {
	int size, speed, dir;

	Fish(int size, int speed, int dir) {
		this.size = size;
		this.speed = speed;
		this.dir = dir;
	}
}

class Tuple {
	int row, col, dir;

	Tuple(int row, int col, int dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}

public class B17143 {
	static int R;
	static int C;

	static Tuple get_next(int x, int y, int speed, int dir) {
		// Sharks move at a set speed every 1 second.
		for (int i = 0; i < speed; i++) {
			if (dir == 0) { // up
				if (x == 0) {
					x = 1;
					dir = 1;
				} else {
					x -= 1;
				}
			} else if (dir == 1) { // down
				if (x == R - 1) {
					x = R - 2;
					dir = 0;
				} else {
					x += 1;
				}
			} else if (dir == 2) { // right
				if (y == C - 1) {
					y = C - 2;
					dir = 3;
				} else {
					y += 1;
				}
			} else if (dir == 3) { // left
				if (y == 0) {
					y = 1;
					dir = 2;
				} else {
					y -= 1;
				}
			}
		}
		// return position and direction because it doesn't change
		return new Tuple(x, y, dir);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// size of matrix
		R = sc.nextInt();
		C = sc.nextInt();
		// number of sharks
		int m = sc.nextInt();

		// Put a class in each array
		Fish[][] fish = new Fish[R][C];
		Fish[][] nfish = new Fish[R][C]; // next fish (need to overwrite)

		// init
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				fish[i][j] = new Fish(0, 0, 0);
				nfish[i][j] = new Fish(0, 0, 0);
			}
		}

		// sharks info input
		while (m-- > 0) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int s = sc.nextInt();
			int d = sc.nextInt() - 1;
			int z = sc.nextInt();
			fish[r][c] = new Fish(z, s, d);
		}

		int ans = 0;
		// Fisherman move left
		for (int j = 0; j < C; j++) {
			// If there is a shark and catch it
			for (int i = 0; i < R; i++) {
				if (fish[i][j].size > 0) {
					ans += fish[i][j].size;
					fish[i][j].size = 0;
					break;
				}
			}
			// sharks move
			for (int l1 = 0; l1 < R; l1++) {
				for (int l2 = 0; l2 < C; l2++) {
					if (fish[l1][l2].size == 0) {
						continue;
					}
					Fish f = fish[l1][l2]; // Shark's information
					Tuple temp = get_next(l1, l2, f.speed, f.dir); // Shark position after 1 second

					// Shark's next info
					int x = temp.row;
					int y = temp.col;
					int dir = temp.dir;
					// Big shark eat smaller shark
					if (nfish[x][y].size == 0 || nfish[x][y].size < f.size) {
						nfish[x][y] = new Fish(f.size, f.speed, dir);
					}
				}
			}
			for (int l1 = 0; l1 < R; l1++) {
				for (int l2 = 0; l2 < C; l2++) {
					fish[l1][l2] = nfish[l1][l2];
					nfish[l1][l2] = new Fish(0, 0, 0);
				}
			}
		}
		System.out.println(ans);
	}

}
