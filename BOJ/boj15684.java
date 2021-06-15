package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//사다리
public class boj15684 {
	static int N,M,H,a,b,answer;
	static boolean line[][];
	static boolean isTrue = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		line = new boolean[H+1][N+2];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			line[a][b] = true;
		}
		for(int i=0;i<=3;i++){
			answer=i;
			dfs(1,0);
			if(isTrue){
				System.out.println(answer);
				return;
			}
		}
		System.out.println("-1");
		
	}
	private static void dfs(int start, int cnt) {
		if(cnt==answer){
			boolean check=true;
			for(int i=1;i<=N;i++){
				int point = i;
				for(int j=1;j<=H;j++){
					if(line[j][point] == true){
						++point;
					}else if(point>1 && line[j][point-1]){
						--point;
					}
				}
				if(i!=point){
					check=false;
					break;
				}
			}
			if(check){
				isTrue=true;
			}return;
		}
		for(int i=start;i<=H;i++){
			for(int j=1;j<=N;j++){
				if(!line[i][j-1] && !line[i][j] && !line[i][j+1]){
					line[i][j] = true;
					dfs(i,cnt+1);
					line[i][j] = false;
				}
			}
		}
		
	}

	

}
