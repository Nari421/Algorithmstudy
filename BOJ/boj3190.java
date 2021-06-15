package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3190 {
	static int N,K,map[][],L,answer=0;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static int time[];
	static char direction[];
	static class Dot{
		int x,y;
		public Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Dot> snake = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for(int i=0;i<=N;i++){
			for(int j=0;j<=N;j++){
				map[i][j] = 0;
			}
		}
		map[1][1] = 1;
		for(int i=0;i<K;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		L = Integer.parseInt(br.readLine());
		time = new int[L];
		direction = new char[L];
		for(int i=0;i<L;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			direction[i] = st.nextToken().charAt(0);
		}
		snake.add(new Dot(1,1));
		playGame();
		System.out.println(answer);
	}
	private static void playGame() {
		int i=0,d=2,row=1,col=1;
		while(true){
			if(i<L && answer == time[i]){
				if(direction[i] == 'D'){
					d = (d+1)%4;
				}else{
					d = (d+3)%4;
				}
				i++;
			}
			int nx = row+dx[d];
			int ny = col+dy[d];
			
			if(nx>N||ny>N||nx<1||ny<1){
				answer++;
				break;
			}
			if(map[nx][ny]==2){
				snake.add(new Dot(nx,ny));
				map[nx][ny]=1;
			}else if(map[nx][ny] == 1){
				answer++;
				break;
			}else if(map[nx][ny]==0){
				map[nx][ny] = 1;
				Dot dot = snake.poll();
				snake.add(new Dot(nx,ny));
				map[dot.x][dot.y] =0;
			}
			row = nx;
			col = ny;
			answer++;
			
		}
		
	}

}
