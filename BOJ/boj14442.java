package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14442 {

	static int n,m,k,map[][],answer=Integer.MAX_VALUE,max=0;
	static boolean visit[][][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static class Dot{
		int x,y,dist,breakwall;
		public Dot(int x, int y,int dist,int breakwall){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakwall = breakwall;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visit = new boolean[n+1][m+1][k+1];
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = s.charAt(j-1)-48;
			}
		}
		bfs();
		if(answer == Integer.MAX_VALUE)answer=-1;
		System.out.println(answer);
	}
	private static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(1,1,1,0));
		visit[1][1][0] = true;
		while(!q.isEmpty()){
			Dot d = q.poll();
			if(d.x == n && d.y == m){
				answer = answer>d.dist?d.dist:answer;
				return;
			}
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				
				if(nx<=0 || ny<=0 || nx>n||ny>m)continue;
				
				if(map[nx][ny]==0){
					if(visit[nx][ny][d.breakwall]) continue;//지나왔던
					q.add(new Dot(nx,ny,d.dist+1,d.breakwall));
					visit[nx][ny][d.breakwall] = true; // 이제 지남
				}else{
					if(d.breakwall <k && !visit[nx][ny][d.breakwall+1]){
						q.add(new Dot(nx,ny,d.dist+1,d.breakwall+1));
						visit[nx][ny][d.breakwall+1] = true;
					}
					
					
				}
			}
		}
	}

}
