package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1261 {
	static int n,map[][],m,copy[][];
	static boolean visit[][],success=false,isDone= false;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static class Dot implements Comparable<Dot>{
		int x,y,dist;
		public Dot(int x,int y,int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Dot d){
			return this.dist - d.dist;
		}
	}
	static LinkedList<Dot> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		copy = new int[m][n];
		
		for(int i=0;i<m;i++){
			String str = br.readLine();
			for (int j = 0; j <n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		int answer =0;
//		for(int i=0;i<n*m-2;i++){
//			answer =i;
//			System.out.println("answer = "+i);
//			algospot(0,0,i);
//			
//			if(isDone){
//				System.out.println(answer);
//				return;
//			}
//		}
		
		System.out.println(bfs());
	}
	private static void algospot(int start, int index, int broken) {
		if(broken == index){
			copyMap();
			bfs();
			if(success){
				isDone = true;
				return;
			}
			return;
		}
		for(int i=start;i<m;i++){
			for(int j=0;j<n;j++){
				if(map[i][j] == 1){
					map[i][j] = 0;
					algospot(i,index+1,broken);
					map[i][j] =1;
				}
			}
		}
		
	}
	private static int bfs() {
		visit = new boolean[m][n];

		PriorityQueue<Dot> q = new PriorityQueue<>();
		q.add(new Dot(0,0,0));
		visit[0][0] = true;
		//success=false;
		while(!q.isEmpty()){
			Dot d = q.poll();
			if(d.x == m-1 && d.y == n-1){
				return d.dist;
				
			}
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0||ny<0||nx>=m||ny>=n) continue;
				if(!visit[nx][ny]){
					if(map[nx][ny] == 0){
						q.add(new Dot(nx,ny,d.dist));
					}else{
						q.add(new Dot(nx,ny,d.dist+1));
					}
				}
//				if(copy[nx][ny] == 0 && visit[nx][ny] == false){
//					q.add(new Dot(nx,ny,));
//					visit[nx][ny] = true;
//				}
				
			}
		}
		return -1;
	}
	private static void copyMap() {
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				copy[i][j] = map[i][j];
			}
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
