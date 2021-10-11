package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2458 {
	static int n,m,map[][];
	static boolean[][] visit;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = -1;
		}
		for(int i = 1; i <= n; i++){//경유
            for(int j = 1; j <= n; j++){//출발
                for (int k = 1; k <= n; k++) {//도착
                	if(j==k)continue;
                	if(map[j][i]+map[i][k] == 2){
                		map[j][k]=1;
                		map[k][j] = -1;
                	}
                }
            }
            
        }
		int answer=0;
		for(int i=1;i<=n;i++){
			for (int j = 1; j <= n;j++) {
				if(map[i][j]==0&& i!=j){
					answer++;
					break;
				}
			}
		}
		System.out.println(n-answer);

	}

}
