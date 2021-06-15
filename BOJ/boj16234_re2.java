package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234_re2 {
	static int n,map[][],time,sx=0,sy=0,sharksize = 2,fishcount=0;
	static boolean visit[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
//	static int[] dx = {1,-1,0,0};
//    static int[] dy = {0,0,-1,1};
	static class Dot{
		int x,y,dist;
		public Dot(int x,int y,int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static LinkedList<Dot> fish;
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			StringTokenizer st ;
			for(int i=0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 9){
						sx = i;
						sy = j;
						map[i][j] =0;
					}
				}
			}
			while(true){
				fish = new LinkedList<>();
				Queue<Dot> q = new LinkedList<>();
				q.add(new Dot(sx,sy,0));
				visit = new boolean[n][n];
				visit[sx][sy] = true;
				while(!q.isEmpty()){
					Dot d = q.poll();
					for(int i=0;i<4;i++){
						int nx = d.x+dx[i];
						int ny = d.y+dy[i];
						
						if(nx<0||ny<0||nx>=n||ny>=n)continue;
						if(visit[nx][ny] == true)continue;
						
						if(1<=map[nx][ny] && map[nx][ny]<sharksize){
							q.add(new Dot(nx,ny,d.dist+1));
							fish.add(new Dot(nx,ny,d.dist+1));
							visit[nx][ny]=true;
						}else if(map[nx][ny] == sharksize || map[nx][ny]==0){
							q.add(new Dot(nx,ny,d.dist+1));
							visit[nx][ny]=true;
						}
					}
				}
				for(Dot dot: fish){
					System.out.println(dot.x+" "+dot.y+" "+dot.dist);
				}
				System.out.println();
				if(fish.size() == 0){
					System.out.println(time);
					return;
				}
				
				Dot eatfish = fish.get(0);
				for(int i=1;i<fish.size();i++){
					if(fish.get(i).dist<eatfish.dist){
						eatfish = fish.get(i);
					}
					if(fish.get(i).dist == eatfish.dist){
						if(eatfish.x > fish.get(i).x){
	                        eatfish = fish.get(i);
	                        continue;
	                    }else if(eatfish.x == fish.get(i).x){
	                        if(eatfish.y > fish.get(i).y);
	                        eatfish = fish.get(i);   
	                    }
					}
				}
				System.out.println("--->"+eatfish.x+" "+eatfish.y+" "+eatfish.dist);
				time+=eatfish.dist;
				fishcount++;
				map[eatfish.x][eatfish.y] =0;
				
				if(fishcount==sharksize){
					sharksize++;
					fishcount=0;
				}
				sx = eatfish.x;
				sy = eatfish.y;
			}
			
	}

}
