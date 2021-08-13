package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1986 {
	static int n, m, K, Q, P;
	static boolean visit[][];
	static int qx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int qy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int kx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int ky[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static char map[][];
	static class dot {
		int x, y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<dot> queen = new ArrayList<>();
	static ArrayList<dot> knight = new ArrayList<>();
	static ArrayList<dot> pawn = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		map = new char[n+1][m+1];
		
		s = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(s.nextToken());
		for(int i=0;i<Q;i++){
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			map[x][y] = 'Q';
			queen.add(new dot(x,y));
		}
		s = new StringTokenizer(br.readLine());
		K = Integer.parseInt(s.nextToken());
		for(int i=0;i<K;i++){
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			map[x][y] = 'K';
			knight.add(new dot(x,y));
		}
		s = new StringTokenizer(br.readLine());
		P = Integer.parseInt(s.nextToken());
		for(int i=0;i<P;i++){
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			map[x][y] = 'P';
			pawn.add(new dot(x,y));
		}
		for(int i=0;i<K;i++){
			attackK(knight.get(i));
		}
		
		for(int i=0;i<Q;i++){
			attackQ(queen.get(i));
		}
		int answer=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(map[i][j] == '\u0000'){
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static void attackK(dot dot) {
		for(int i=0;i<8;i++){
			int nx = dot.x+kx[i];
			int ny = dot.y+ky[i];
			if(nx<=0 || ny<=0||nx>n||ny>m)continue;
			if(map[nx][ny] == '\u0000'){
				map[nx][ny] = 'k';
			}
		}
		
	}

	private static void attackQ(dot dot) {
		for(int i=0;i<8;i++){
			int nx = dot.x+qx[i];
			int ny = dot.y+qy[i];
			while(true) {
				if(nx<=0 || ny<=0||nx>n||ny>m)break;
				if(map[nx][ny] =='P' || map[nx][ny]=='Q'|| map[nx][ny]=='K'){
					break;
				}
				map[nx][ny]='q';
				nx+=qx[i];
				ny+=qy[i];
            }
		}
	}
}
