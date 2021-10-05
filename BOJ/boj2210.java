package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2210 {
	static HashSet<String> set = new HashSet<String>();
	static char map[][] = new char[5][5];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static class number{
		int x,y;
		String s;
		public number(int x,int y,String s){
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++){
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++){
				map[i][j] = str.nextToken().charAt(0);
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				bfs(i,j);
				dfs(i,j,0,"");
			}
		}
		System.out.println(set.size());
	}
	//dfs
	private static void dfs(int x, int y, int cnt,String s) {
		if(cnt == 6){
			set.add(s);
			return;
		}
		for(int i=0;i<4;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<5&&ny<5){
				dfs(nx,ny,cnt+1,s+map[nx][ny]);
			}
		}
		
	}
	
	//bfs
	private static void bfs(int x,int y) {
		Queue<number> q = new LinkedList<>();
		q.add(new number(x,y,map[x][y]+""));
		while(!q.isEmpty()){
			number num = q.poll();
			
			for(int i=0;i<4;i++){
				int nx = num.x+dx[i];
				int ny = num.y+dy[i];
				if(nx>=0 && ny>=0 && nx<5&&ny<5){
					String tmp = num.s+map[nx][ny];
					if(tmp.length() == 6){
						set.add(tmp);
						continue;
					}
					q.add(new number(nx,ny,tmp));
				}
			}
		}
		
	}

}
