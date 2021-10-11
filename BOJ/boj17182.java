package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17182 {
	static int n,k,map[][],min = Integer.MAX_VALUE;
	static boolean[] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++){//경유
            for(int j = 0; j < n; j++){//출발
                for (int k = 0; k < n; k++) {//도착
                	if(map[j][k]>map[j][i]+map[i][k]){
                		map[j][k] = map[j][i]+map[i][k];
                	}
                }
            }
        }
		visit[k] = true;
		dfs(0,k,0);
		System.out.println(min);
	}
	private static void dfs(int cnt,int start,int sum) {
		if(cnt == n-1){
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<n;i++){
			if(!visit[i]){
				visit[i] = true;
				dfs(cnt+1,i,sum+map[start][i]);
				visit[i] = false;
			}
		}
		
	}

}
