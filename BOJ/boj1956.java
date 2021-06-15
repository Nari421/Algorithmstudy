package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1956 {
	static int V,E,line[][];
	final static int INF = 100 * 100_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		line = new int[V+1][V+1];
		for(int i = 0 ; i <= V; i++)
            Arrays.fill(line[i], INF);
		for(int i=1;i<=E;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			line[a][b] = c;
		}
		
		//플로이드 와샬..?
		for(int i = 1; i <= V; i++){//경유
            for(int j = 1; j <= V; j++){//출발
                for (int k = 1; k <= V; k++) {//도착
                	if(line[j][k]>line[j][i]+line[i][k]){
                		line[j][k] = line[j][i]+line[i][k];
                	}
                }
            }
        }

		int min = INF;
		for(int i=1;i<=V;i++){
			min = min>line[i][i]?line[i][i]:min;
		}
		
		if(min == INF)System.out.println("-1");
		else System.out.println(min);
	}

}
