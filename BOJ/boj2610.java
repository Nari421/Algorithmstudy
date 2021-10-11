package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2610 {
	private static final int INF = Integer.MAX_VALUE;
	static int n, m, map[][], group = 0;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		// 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}

		ArrayList<Integer> readerList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				readerList.add(bfs(i));
			}
		}
		System.out.println(readerList.size());
		Collections.sort(readerList);
		for (int i : readerList) {
			System.out.println(i);
		}

	}

	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		ArrayList<Integer> arrlist = new ArrayList<>();
		arrlist.add(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i <= n; i++) {
				if (map[now][i] != INF && !visit[i]) {
					visit[i] = true;
					q.add(i);
					arrlist.add(i);

				}
			}
		}

		floydWarshall();
		int index = -1;
		int res = INF;
		for (int i = 1; i <= n; i++) {
			if (!arrlist.contains(i))
				continue;
			int total = 0;
			for (int j = 1; j <= n; j++) {
				if (!arrlist.contains(j))
					continue;
				total = Math.max(total, map[i][j]);
			}
			if (res > total) {
				res = total;
				index = i;
			}
		}
		return index;
	}

	private static void floydWarshall() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					 if (map[i][k] == INF || map[k][j] == INF || i == j)continue;
					 map[i][j] =Math.min( map[i][j],map[i][k] + map[k][j]);
				}
			}
		}
	}

}
