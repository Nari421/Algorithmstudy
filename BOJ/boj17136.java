package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17136 {
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int map[][],min = Integer.MAX_VALUE;
	static boolean[][] cover;
	static int[] papers = {0,5,5,5,5,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		cover = new boolean[10][10];
		for(int i=0;i<10;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		if(min == Integer.MAX_VALUE)min=-1;
		System.out.println(min);
	}
	private static void dfs(int x, int y, int cnt) {
		if(x == 9 && y == 10){
			min = Math.min(min, cnt);
			return;
		}
		if(y == 10){
			dfs(x+1,0,cnt);
			return;
		}
		if(cnt>=min)return;
		
		if(map[x][y] == 1){
			for(int i=5;i>0;i--){
				if(papers[i]>0  && isAttach(x, y, i)){
					attach(x,y,i,0);
					papers[i]--;
					dfs(x,y+1,cnt+1);
					attach(x,y,i,1);
					papers[i]++;
				}
			}
		}else{
			dfs(x,y+1,cnt);
		}
		
	}
	// 색종이를 붙이는 함수.
    public static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
	public static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
 
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
	
	

}
