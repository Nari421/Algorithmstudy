package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj15684_re2 {
	static int n,m,h,line[][],answer=-1;
	static boolean[][] visit;
	static boolean isDone=false;
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x =x;
			this.y = y;
		}
	}
	static LinkedList<dot> list = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		line = new int[h+1][n+2];
		visit = new boolean[h+1][n+2];
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			line[x][y] = 1;
			visit[x][y] = true;
		}
		
		for (int i = 0; i <= 3; i++) {
			findLine(i,1,0);
			if(isDone){
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	private static void findLine(int index, int start, int cnt) {
		System.out.println("index:"+index);
		if(index == cnt){
			if(startgame()){
				isDone = true;
				return;
			}
			return;
		}
		for(int i=start;i<=h;i++){
			for(int j=1;j<=n;j++){
				if(!visit[i][j-1] && !visit[i][j] && !visit[i][j+1]){
					visit[i][j] = true;
					findLine(index,i,cnt+1);
					visit[i][j] = false;
				}
			}
		}
	}
	private static boolean startgame() {
		boolean isPossible=false;
		for(int j=1;j<=n;j++){
			int origin = j;
			int start = j;
			System.out.println("start : "+start);
			for(int i=1;i<h+1;i++){//게임 시작
				if(visit[i][start]){
					start+=1;
				}else if(start>1 && visit[i][start-1]){
					start-=1;
				}
			}
			System.out.println(start);
			if(origin == start){
				System.out.println("true");
				isPossible = true;
			}else{
				return false;
			}
		}
		return isPossible;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
