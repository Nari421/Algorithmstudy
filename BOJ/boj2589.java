package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589 {
	static int n,m,answer=0,max=0;
	static boolean visit[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static char map[][],copy[][];
	static class dot{
		int x,y,count;
		public dot(int x, int y,int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	static ArrayList<dot> land = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i=0;i<n;i++){
			String input = br.readLine();
			for(int j=0;j<m;j++){
				if(input.charAt(j)=='L')land.add(new dot(i,j,0));
				map[i][j] = input.charAt(j);
			}
		}
		for(int i=0;i<land.size();i++){
			visit = new boolean[n][m];
			bfs(land.get(i).x,land.get(i).y);
			
			answer = Math.max(max, answer);
			max=0;
		}
		System.out.println(answer);
	}
	private static void bfs(int x, int y) {
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(x,y,0));
		visit[x][y] = true;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0 || ny<0|| nx>=n || ny>=m)continue;
				if(map[nx][ny]=='L'&& !visit[nx][ny]){
					int cnt = d.count+1;
					q.add(new dot(nx,ny,cnt));
					visit[nx][ny] = true;
					max = Math.max(cnt, max);
				}
			}
		}
	}

}
