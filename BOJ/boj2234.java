package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class boj2234 {
	static int n, m, map[][], answer = 0, max = 0, area = 1;
	static boolean visit[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static LinkedList<Integer> room = new LinkedList<>();

	static class Dot {
		int x, y, wall;

		public Dot(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		map = new int[m][n];

		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		int cnt = 0, extension = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == false) {
					findconnect(cnt, i, j);
					cnt++;
					max = Math.max(area, max);
					room.add(area);
					area = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int ni = i + dx[k], nj = j + dy[k];
					if (ni < 0 || ni >= m || nj < 0 || nj >= n)
						continue;
					int x = map[i][j], y = map[ni][nj];
					if (x != y) {
						int sum = room.get(x) + room.get(y);
						if (extension < sum)
							extension = sum;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		System.out.println(extension);

	}

	private static void findconnect(int cnt, int x, int y) {
		String binary = Integer.toBinaryString(map[x][y]);
		visit[x][y] = true;
		map[x][y] = cnt;

		if (binary.length() != 4) {
			while (binary.length() != 4) {
				binary = "0" + binary;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (binary.charAt(i) == '0') {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if (visit[nx][ny] == false) {
					++area;
					findconnect(cnt, nx, ny);
				}

			}
		}
	}

}
