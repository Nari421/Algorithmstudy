package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
	static int n,m,answer,map[][];
	static boolean visit[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
	static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(visit[i][j]==false){
					visit[i][j] = true;
					dfs(i,j,map[i][j],1);
					visit[i][j] =false;
					dfsfor3(i,j);
				}
			}
		}
		System.out.println(answer);

	}
	private static void dfs(int x, int y, int sum, int length) {
		if(length>=4){
			answer = sum>answer?sum:answer;
			return;
		}
		for(int i=0;i<4;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m)continue;
			
			if(visit[nx][ny] == false){
				visit[nx][ny] = true;
				dfs(nx,ny,sum+map[nx][ny],length+1);
				visit[nx][ny] = false;
			}
		}
	}
	private static void dfsfor3(int x, int y) {
		
		for(int i=0;i<4;i++){
			boolean isTrue = true;
			int sum=0;
			for(int j=0;j<4;j++){
				int nx = x+ex[i][j];
				int ny = y+ey[i][j];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m){
					isTrue = false;
					break;
				}
				else{
					sum+=map[nx][ny];
				}
			}
			if(isTrue){
				answer = sum>answer?sum:answer;
			}
		}
	}
	
}
