package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj19237 {
	static int n, m, k, map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class fish implements Comparable<fish> {
		int num, x, y, d;

		public fish(int num, int x, int y, int d) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(fish f) {
			return this.num - f.num;
		}
	}

	static boolean isdone = false;
	static int[][] sdir, e;
	static ArrayList<fish> shark = new ArrayList<>();
	private static int[][][] dirPriority;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dirPriority = new int[m + 1][4][4];
		sdir = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int id = Integer.parseInt(st.nextToken());
				sdir[i][j] = id;
				if (id != 0) {
					shark.add(new fish(id, i, j, 0));
					map[i][j] = k;
				}else{
					map[i][j] = 0;
				}
			}
		}
		
		Collections.sort(shark);
		st = new StringTokenizer(br.readLine());
		for (fish f : shark) {
			f.d = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					dirPriority[i][j][k] = Integer.valueOf(st.nextToken()) - 1;
				}
			}
		}
		int time = 0;
		while (time <= 1000) {
			move();
			remove();
			if (isdone) {
				break;
			}time++;
		}
		time = time > 1000 ? -1 : time;
		System.out.println(time);
	}

	private static void remove() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 기존 냄새 감소
				if (map[i][j] != 0) {
					int newSmell = map[i][j] - 1;

					if (newSmell == 0) {
						sdir[i][j] = 0;
					}
					map[i][j] = newSmell;
				}

				// 움직인 후 상어가 위치한 칸이면 새로운 냄새 뿌림
				if (e[i][j] != 0) {
					sdir[i][j] = e[i][j];
					map[i][j] = k;
				}
			}
		}
	}

	private static void move() {
		e = new int[n][n];
		int diecnt = 0;
		for (fish f : shark) {
			if (f.d == -1) {
				diecnt++;
				continue;
			}
			int num = f.num;
			int sx = f.x;
			int sy = f.y;
			int dir = f.d;
			boolean done = false;
			for (int i = 0; i < 4; i++) {
				int nd = dirPriority[num][dir][i];// 원래 방향의 선호하는 항뱡
				int nx = sx + dx[nd];
				int ny = sy + dy[nd];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0)
					continue;
				if (num != 1 && e[nx][ny] < num && e[nx][ny] >= 1) {
					f.d = -1;
				} else {
					e[nx][ny] = num;
					f.x = nx;
					f.y = ny;
					f.d = nd;
				}
				done = true;
				break;
			}
			if (!done) {
				for (int i = 0; i < 4; i++) {
					int nd = dirPriority[num][dir][i];
					int nx = sx + dx[nd];
					int ny = sy + dy[nd];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || sdir[nx][ny] != num)
						continue;
					
					e[nx][ny] = num;
					f.x = nx;
					f.y = ny;
					f.d = nd;
					break;
				}
			}
		}
		if (diecnt == m - 1) {
			isdone = true;
			return;
		}
	}

}
