package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj21610 {
	static class dot{
		int x,y;
		public dot(int x, int y){
			this.x = x;
			this.y=y;
		}
	}
	static int n,m,map[][],sum=0;
	static boolean[][] visit;
	static int[] dr = {0,-1,-1,-1,0, 1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static ArrayList<dot> cloudlist=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][n];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//구름 위치
		for(int i=n-2;i<n;i++){
			for(int j=0;j<2;j++){
				cloudlist.add(new dot(i,j));
				System.out.println(i+" "+j);
			}
		}
		
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			for(dot dd:cloudlist){
				moveCloud(dd,d,s);
				System.out.println("변경 후: "+dd.x+ " , "+dd.y);
			}
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[k][j]+" ");
				}System.out.println();
			}System.out.println("-----------------------");
			visit = new boolean[n][n];
			startRain();
		}
		System.out.println(sum);
	}
	private static void startRain() {
		int cnt=0;
		for(dot d:cloudlist){
			int x = d.x;
			int y = d.y;
			visit[x][y] = true;
			cnt=0;
			for(int i=1;i<8;i+=2){
				int nx = x+dr[i];
				int ny = y+dc[i];
				if(nx<0||nx>=n||ny<0||ny>=n)continue;
				if(map[nx][ny]>=1)cnt++;
			}
			map[x][y]+=cnt;
			System.out.println(x+" "+y+"cny: "+cnt);
		}cloudlist.clear();
		System.out.println(" 주변 비 ㅇ확인");
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[k][j]+" ");
			}System.out.println();
		}System.out.println("-----------------------");
		sum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]>=2 && !visit[i][j]){
					cloudlist.add(new dot(i,j));
					System.out.println("new cloud : "+i+" ,"+j);
					map[i][j]-=2;
				}
				sum+=map[i][j];
			}
		}
		System.out.println(" 새로운 비구름");
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[k][j]+" ");
			}System.out.println();
		}System.out.println("-----------------------");
	}
	
	private static void moveCloud(dot d, int dir, int s) {
		int nr = (d.x+n+dr[dir]*(s%n))%n;
		int nc = (d.y+n+dc[dir]*(s%n))%n;
		d.x = nr;
		d.y = nc;
		map[d.x][d.y]++;
	}
	
}
