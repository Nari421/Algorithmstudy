package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj20058 {
	static int N, Q, map[][], L, max = 0, sum = 0;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (Q-- > 0) {
			L = Integer.parseInt(st.nextToken());
			int l = (int) Math.pow(2, L);
			rotate(l);
			melt();
			System.out.println(Q);
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[k][j] + " ");
				}
				System.out.println();
			}
			System.out.println("---------------------");
		}
		visit = new boolean[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sum+=map[i][j];
				if(map[i][j]>0 && !visit[i][j]){
					visit[i][j]=true;
					max = Math.max(max, countLand(i,j));
				}
			}
		}
		System.out.println(sum+" "+max);

	}

	private static int countLand(int x,int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{x,y});
		int cnt=1;
		while(!q.isEmpty()){
			int[] arr = q.poll();
			for(int i=0;i<4;i++){
				int nr = arr[0] + dr[i];
				int nc = arr[1] + dc[i];
				if(nr<0||nr>=N||nc<0||nc>=N)continue;
				if(visit[nr][nc] == false && map[nr][nc]>=1){
					visit[nr][nc] = true;
					q.add(new int[]{nr,nc});
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void melt() {
		ArrayList<int[]> ice = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				if(map[i][j]==0)continue;
				for (int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if(nr<0||nr>=N||nc<0||nc>=N)continue;
					if(map[nr][nc]>=1)count++;
				}
				if (count < 3) {
					ice.add(new int[] { i, j });
				}

			}
		}
		for (int[] i : ice) {
			System.out.println(i[0] + " " + i[1] + " ");
			map[i[0]][i[1]]--;
		}

	}

	private static void rotate(int l) {
		int[][] rotate = new int[N][N];
		for (int i = 0; i < N; i += l) {
			for (int j = 0; j < N; j += l) {
				for (int a = 0; a < l; a++) {
					for (int b = 0; b < l; b++) {
						rotate[i + b][j - a + l - 1] = map[i + a][j + b];
					}
				}
			}
		}
		map = rotate;
		System.out.println("최종");
		for (int k = 0; k < N; k++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[k][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

}
