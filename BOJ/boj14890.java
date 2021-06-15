package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj14890 {
	static int n,l,map[][],answer=0;
	static boolean visit[][];
	static class Dot{
		int x,y;
		public Dot(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map=new int[n][n];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			}
			
		}
		int index=0;
		//가로방향
		for (int i = 0; i < n; i++) {
			if(setincline(map[i])){
				answer++;
			}
		}
		int rotate[][] = rightRotate(map);
		for (int i = 0; i < n; i++) {
			if(setincline(rotate[i])){
				answer++;
			}
		}
		System.out.println("answer:"+answer);

	}
	private static int[][] rightRotate(int[][] map2) {
		// TODO Auto-generated method stub
		int[][] result = new int[n][n];
		for(int i=0;i<n;i++){
			for (int j = 0; j < n; j++) {
				result[i][j] = map2[n-j-1][i];
			}
		}
		return result;
	}
	private static boolean setincline(int[] pass) {
		boolean[] visited = new boolean[n];
		
		for(int i=0;i<n;i++){
			if(pass[i] == pass[i+1])continue;
			
			if(Math.abs(pass[i]-pass[i+1])>1){
				return false;
			}
			
			if(pass[i] -1 == pass[i+1]){
				//낮은 경우
				for(int j=i+1;j<=i+l;j++){
					if(j>=n || visited[j]||pass[j]!=pass[i+1]){
						return false;
					}
					visited[j] = true;
				}
				
			}else if(pass[i]+1 == pass[i+1]){
				//높은 경우
				for(int j = i; j > i - l; j--) {
                    if (j < 0 || visited[j] || pass[j] != pass[i]) {
                        return false;
                    }
                    visited[j] = true;
				}
			}
		}
		return true;
	}
}
























