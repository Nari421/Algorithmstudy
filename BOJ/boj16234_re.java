package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234_re {
	static int N,L,R,nation[][],answer=0;
	static boolean visit[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
//	static int dx[] = {0,0,-1,1};
//	static int dy[] = {1,-1,0,0};
	static class Dot{
		int x,y;
		public Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static LinkedList<Dot> list = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nation = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true){
			visit = new boolean[N][N];
			if(!unioncheck()){
				answer++;
			}else{
				break;
			}
		}
		System.out.println(answer);
	}
	private static boolean unioncheck() {
		boolean isDone = true;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visit[i][j] ==false){
					list.clear();
					list.add(new Dot(i,j));
					visit[i][j] = true;
					findunion(i,j);
					if(list.size()>1){
						move();
						isDone = false;
					}
				}
			}
		}
		return isDone;
	}
	private static void move() {
		int sum=0;
		for(Dot d:list){
			sum+=nation[d.x][d.y];
		}
		int agv=sum/list.size();
		for(Dot d:list){
			nation[d.x][d.y]=agv;
		}
		System.out.println(agv);
	}
	private static void findunion(int x,int y) {
		//bfs
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(x,y));
		
		while(!q.isEmpty()){
			Dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x +dx[i];
				int ny = d.y+ dy[i];

				if(nx<0 || ny<0 || nx>=N || ny>= N)continue;
				if(visit[nx][ny]==false){
					int sub = Math.abs(nation[d.x][d.y]-nation[nx][ny]);
					if(L<=sub && sub<=R){
						System.out.println("i: "+i+" /"+nx+" "+nx);
						list.add(new Dot(nx,ny));
						visit[nx][ny] =true;
						q.add(new Dot(nx,ny));
					}
				}
			}
		}
	}
	
	
}
