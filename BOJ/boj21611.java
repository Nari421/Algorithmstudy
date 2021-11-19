package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj21611 {
	static int n, m, map[][], score = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static LinkedList<Integer> newlist = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[n / 2][n / 2] = 4;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			attackIce(d, s);
			moveBall();
			bombBall();
			divideBall();
		}
		System.out.println(score);
	}

	private static void divideBall() {
		LinkedList<Integer> list = new LinkedList<>();
		int sharkx = n / 2;
		int sharky = n / 2;
		int tx = sharkx;
		int ty = sharky;
		int[] dx = new int[] { 0, 1, 0, -1 };
		int[] dy = new int[] { -1, 0, 1, 0 };
		int dir = 0;
		int value = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < i + 1; k++) {
					tx += dx[dir];
					ty += dy[dir];
					if (tx < 0 || ty < 0 || tx >= n || ty >= n || map[tx][ty] == 0)
						continue;
					if (map[tx][ty] == value) {
						list.add(value);
					} else {
						if(value!=0){
							int size = list.size();// 연결된 개수
							newlist.add(size);
							newlist.add(value);
						}
						value = map[tx][ty];
						list.clear();
						list.add(value);
					}
				}
				dir = dir == 3 ? 0 : dir + 1;
			}
		}
		map = inputnewValue();
		
		newlist.clear();
	}

	private static int[][] inputnewValue() {
		int[][] map2 = new int[n][n];
		int sharkx = n / 2;
		int sharky = n / 2;
		int tx = sharkx;
		int ty = sharky;
		int dir = 0,cnt=0;
		map2[tx][ty]= 4;
		int[] dx = new int[] { 0, 1, 0, -1 };
		int[] dy = new int[] { -1, 0, 1, 0 };
		int size = newlist.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < i + 1; k++) {
					tx += dx[dir];
					ty += dy[dir];
					if (tx < 0 || ty < 0 || tx >= n || ty >= n)
						continue;
					map2[tx][ty] = newlist.get(cnt++);
					if(cnt == size)return map2;
					if (tx == 0 && ty == 0)
						return map2;
				}
				dir = dir == 3 ? 0 : dir + 1;
				if(cnt == newlist.size())break;
			}
		}
		
		return map2;
	}

	private static void bombBall() {
		LinkedList<int[]> list = new LinkedList<>();
		int sharkx = n / 2;
		int sharky = n / 2;
		int tx = sharkx;
		int ty = sharky;
		int[] dx = new int[] { 0, 1, 0, -1 };
		int[] dy = new int[] { -1, 0, 1, 0 };
		int dir = 0;
		int value = 0, cnt = 0;
		boolean connect = false;
		while (true) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < i + 1; k++) {
						tx += dx[dir];
						ty += dy[dir];
						if (tx < 0 || ty < 0 || tx >= n || ty >= n || map[tx][ty] == 0)
							continue;
						if (map[tx][ty] == value) {
							list.add(new int[] { tx, ty });
							cnt++;
						} else if (map[tx][ty] != value) {
							if (cnt >= 4) {
								for (int[] l : list) {
									map[l[0]][l[1]] = 0;
								}
								score += value * list.size();
								connect = true;
							}
							cnt = 1;
							list.clear();
							list.add(new int[] { tx, ty });
							value = map[tx][ty];
						}
						if (tx == 0 && ty == 0)
							break;
					}
					dir = dir == 3 ? 0 : dir + 1;
				}
			}
			if (connect == false){
				break;
			}
			moveBall();
			connect = false;
			value = 0;
			cnt = 0;
			dir = 0;
			tx = sharkx;
			ty = sharky;
		}

	}

	private static void moveBall() {
		Stack<int[]> s = new Stack<>();
		int sharkx = n / 2;
		int sharky = n / 2;
		int tx = 0;
		int ty = 0;
		int dir = 0;
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		if(map[tx][ty]!=0){
			s.push(new int[]{tx,ty,map[tx][ty]});
			map[tx][ty] = 0;
		}
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < 2; j++) {
				for (int k = i; k > 0; k--) {
					tx += dx[dir];
					ty += dy[dir];
					if (tx < 0 || ty < 0 || tx >= n || ty >= n) {
						tx -= dx[dir];
						ty -= dy[dir];
						continue;
					}
					if (tx == sharkx && ty == sharky)
						break;
					if (map[tx][ty] != 0) {
						s.push(new int[] { tx, ty, map[tx][ty] });
						map[tx][ty] = 0;
					}

				}
				dir = dir == 3 ? 0 : dir + 1;
				if (i == n)
					j += 3;
			}
		}
		tx = sharkx;
		ty = sharky;
		dx = new int[] { 0, 1, 0, -1 };
		dy = new int[] { -1, 0, 1, 0 };
		dir = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < i + 1; k++) {
					tx += dx[dir];
					ty += dy[dir];
					if (tx < 0 || ty < 0 || tx >= n || ty >= n)
						continue;
					map[tx][ty] = s.pop()[2];
					if (s.size() == 0)
						return;
					if (tx == 0 && ty == 0)
						return;
				}
				dir = dir == 3 ? 0 : dir + 1;
			}
		}
	}

	private static void attackIce(int d, int s) {
		int sharkx = n / 2;
		int sharky = n / 2;
		int nx = sharkx;
		int ny = sharky;
		while (s-- > 0) {
			nx += dr[d];
			ny += dc[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				break;
			map[nx][ny] = 0;
		}

	}

}
