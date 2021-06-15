package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj19238 {
	static int n,m,fuel,map[][],taxi_x,taxi_y,answer=0,copy[][],cnt=0;
	static boolean visit[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static class guest{
		int sx,sy,ax,ay,dist;
		public guest(int sx,int sy,int ax,int ay,int dist){
			this.sx =sx;
			this.sy =sy;
			this.ax =ax;
			this.ay	=ay;
			this.dist =dist;
		}
		
	}
	static class Dot{
		int x, y,dist;
		public Dot(int x,int y,int dist){
			this.x = x;
			this.y=y;
			this.dist=dist;
		}
	}
	static LinkedList<guest> glist = new LinkedList<>();
	static LinkedList<guest> taxilist = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		taxi_x = Integer.parseInt(st.nextToken());
		taxi_y = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy =Integer.parseInt(st.nextToken());
			int ax =Integer.parseInt(st.nextToken());
			int ay=Integer.parseInt(st.nextToken());
			glist.add(new guest(sx,sy,ax,ay,0));
		}
		//경로 짧은 고객
		
		while(!glist.isEmpty()){
			//택시부터 거리찾기
			taxiToguest(taxi_x, taxi_y);
			
			for(int i=glist.size()-1;i>=0;i--){
				if(glist.get(i).dist ==-1){
					glist.remove(i);
				}
			}
			if(glist.size()>0){
				Collections.sort(glist, new Comparator<guest>() {
		            @Override
		            public int compare(guest g1, guest g2) {
		            	if(g1.dist<g2.dist)
							return -1;
						else if(g1.dist>g2.dist)
							return 1;
						else if(g1.dist == g2.dist){
							if(g1.sx<g2.sx)
								return -1;
							else if(g1.sx>g2.sx)
								return 1;
							else if(g1.sx==g2.sx){
								if(g1.sy<g2.sy)
									return -1;
								else if(g1.sy>g2.sy)
									return 1;
							}
						}
		            	return 0;
		            }
		        });
				
				guestTodestination(glist.get(0));
			}
			if(fuel <= 0){
				System.out.println(-1);
				return;
			}
			
		}
		 if(m<=cnt){
			 System.out.println(fuel);
		 }else {
			 System.out.println(-1);
		 }
		
	}
	private static void guestTodestination(guest guest) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot (guest.sx,guest.sy,0));
		visit = new boolean[n+1][n+1];
		
		visit[guest.sx][guest.sy] = true;
		fuel -= guest.dist;
		if(fuel <= 0){
			return;
		}
		while(!q.isEmpty()){
			Dot d = q.poll();
			if(d.x == guest.ax && d.y == guest.ay){
				fuel -= d.dist;
				if(fuel>=0){
					fuel += d.dist*2;
					cnt++;
					taxi_x = guest.ax;
					taxi_y = guest.ay;
				}
				glist.remove(0);
				return;
			}
			for(int i=0;i<4;i++){
				int nx = d.x +dx[i];
				int ny = d.y +dy[i];
				if(nx<=0 ||ny<=0 ||nx>n||ny>n)continue;
				if(visit[nx][ny] == false && map[nx][ny]!=1){
					visit[nx][ny] = true;
					q.add(new Dot(nx,ny,d.dist+1));
				}
			}
		}
	}
	private static void taxiToguest(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		visit = new boolean[n+1][n+1];
		q.add(new Dot(x,y,0));
		visit[x][y] = true;
		int[][] copy = copymap(map);
		
		while(!q.isEmpty()){
			Dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x +dx[i];
				int ny = d.y +dy[i];
				if(nx<=0 ||ny<=0 ||nx>n||ny>n)continue;
				if(visit[nx][ny] == false && copy[nx][ny]!=1){
					visit[nx][ny] = true;
					copy[nx][ny] = copy[d.x][d.y]+1;
					q.add(new Dot(nx,ny,0));
				}
			}
		}
		for(int i=0;i<glist.size();i++){
			int gx = glist.get(i).sx;
			int gy = glist.get(i).sy;
			if(gx == taxi_x && gy == taxi_y){
				glist.get(i).dist = 0;
			}else{
				if(copy[gx][gy]==0){
					glist.get(i).dist =-1;
				}else{
					glist.get(i).dist = copy[gx][gy];
				}
			}
			
		}
	}

	private static int[][] copymap(int[][] map2) {
		int result[][] = new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			System.arraycopy(map2[i], 0, result[i], 0, n);
		}
		return result;
	}

}
