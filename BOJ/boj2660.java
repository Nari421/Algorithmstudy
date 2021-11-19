package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj2660 {
	static int n,map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					map[i][j] = 0;
				else
					map[i][j] = 10000001;
			}
		}
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x == -1 && y==-1)break;
			map[x][y] = map[y][x] = 1;
		}
		for(int k=1;k<=n;k++){
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		int min=Integer.MAX_VALUE;
		int score[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int max=0;
			for (int j = 1; j <= n; j++) {
				if(max<map[i][j])max = map[i][j];
			}score[i] = max;
			min = max>min?min:max;
		}
		ArrayList<Integer> list =new ArrayList<>();
		for(int i=1;i<=n;i++){
			if(score[i] == min)list.add(i);
		}
		System.out.println(min+" "+list.size());
		for(int i:list){
			System.out.print(i+" ");
		}
	}

}
