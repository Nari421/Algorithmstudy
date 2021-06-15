package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16115 {
	static int N,dot[][],index=0;
	static double max=0;
	static int dx[] = {-1,-1,1};
	static int dy[] = {1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dot = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dot[i][0] = Integer.parseInt(st.nextToken());
			dot[i][1] = Integer.parseInt(st.nextToken());
			double x = Math.pow(Math.abs(dot[i][0]-0),2);
			double y = Math.pow(Math.abs(dot[i][1]-0),2);
			double tmp = x+y;
			if(max >tmp){
				max = tmp;
				index = i;
			}
		}

	}

}
