package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018 {
	static int n,m,min=64;
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		visit = new boolean[n][m];//T : w , F : B
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				char ch = string.charAt(j);
				if(ch == 'W'){
					visit[i][j]=true;
				}else if(ch == 'B'){
					visit[i][j] = false;
				}
			}
			
		}
		int n_col = n-7;
		int m_row = m-7;
		
		for(int i=0;i<n_col;i++){
			for(int j=0;j<m_row;j++){
				draw(i,j);
			}
		}
		System.out.println(min);
	}
	private static void draw(int x, int y) {
		int end_x = x+8;
		int end_y = y+8;
		int count=0;
		
		boolean flag = visit[x][y];
		for(int i=x;i<end_x;i++){
			for(int j=y;j<end_y;j++){
				if(flag != visit[i][j]){
					count++;
				}
				flag = !flag;
			}
			flag = !flag;
		}
		count = Math.min(count,64-count);
		min = Math.min(count, min);
		
	}

}
