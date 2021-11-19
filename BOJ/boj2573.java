package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573 {
	static int n,m,map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static ArrayList<dot> ice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++){
			st  = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time=0;
		int land=0;
		while(true){
			land=0;
			boolean[][] visit = new boolean[n][m];
			for(int i=1;i<n;i++){
				for(int j=1;j<m;j++){
					if(map[i][j] > 0 && !visit[i][j]){
						bfs(i,j,visit);
						land++;
					}
				}
			}for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					System.out.print(map[i][j]+" ");
				}System.out.println();
				
			}System.out.println();
			if(land==0){
				time=0;
				break;
			}
			if(land>=2){
				break;
			}
			
			melt();
			time++;
		}
		System.out.println(time);
		
	}
	private static void bfs(int x, int y,boolean[][] visit) {
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0|| ny<0||nx>=n||ny>=m || visit[nx][ny]==true)continue;
				if(map[nx][ny] >0){
					visit[nx][ny] = true;
					q.add(new dot(nx,ny));
				}
			}
		}
	}
	private static void melt() {
		ice = new ArrayList<>();
		boolean[][] visit = new boolean[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(map[i][j] !=0){
					ice.add(new dot(i,j));
					visit[i][j] =true;
				}
			}
		}
		int size = ice.size();
		while(size-- > 0){
			dot d = ice.get(size);
			int sea=0;
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0|| ny<0||nx>=n||ny>=m )continue;
				if(map[nx][ny] == 0 && !visit[nx][ny]){
					sea++;
				}
			}
			if (map[d.x][d.y] - sea < 0) {
                map[d.x][d.y] = 0;
            } else {
                map[d.x][d.y] -= sea;
            }
		}
//		int size= ice.size();
//		boolean[][] visit = new boolean[n][m];
//		while(size-- > 0){
//			dot d = ice.get(size);
//			visit[d.x][d.y] = true;
//			int sea=0;
//			for(int i=0;i<4;i++){
//				int nx = d.x+dx[i];
//				int ny = d.y+dy[i];
//				if(nx<0|| ny<0||nx>=n||ny>=m )continue;
//				if(map[nx][ny] == 0 && !visit[nx][ny]){
//					sea++;
//				}
//			}
//			if (map[d.x][d.y] - sea < 0) {
//                map[d.x][d.y] = 0;
//            } else {
//                map[d.x][d.y] -= sea;
//            }
//			if(map[d.x][d.y]==0)ice.remove(size);
//		}
	}

}
