package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj3184 {
	static int r,c,answer=0,o=0,w=0;
	static char map[][];
	static boolean visit[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<dot> sheep = new ArrayList<>();
	static ArrayList<dot> wolf = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		int o_num=0;
		int w_num=0;
		for(int i=0;i<r;i++){
			String str = br.readLine();
			for(int j=0;j<c;j++){
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o'){
					sheep.add(new dot(i,j));
					o_num++;
				}else if(map[i][j] == 'v'){
					w_num++;
				}
			}
		}
		//.우리 #울타리 o양 v늑대
		for(dot d:sheep){
			if(!visit[d.x][d.y]){
				o++;
				bfs(d.x,d.y);
				if(o>w){
					w_num-=w;
				}else{
					o_num-=o;
				}o=0;w=0;
			}
		}
		System.out.println(o_num+" "+w_num);
	}
	private static void bfs(int x, int y) {
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx <0 || ny<0 ||nx>=r ||ny>=c) continue;
				if(!visit[nx][ny] && map[nx][ny]=='o'){
					visit[nx][ny] = true;
					o++;
					q.add(new dot(nx,ny));
				}else if(!visit[nx][ny] && map[nx][ny]=='v'){
					visit[nx][ny] = true;
					w++;
					q.add(new dot(nx,ny));
				}else if(!visit[nx][ny] && map[nx][ny]=='.'){
					visit[nx][ny] = true;
					q.add(new dot(nx,ny));
				}
			}
		}
		
	}

}
