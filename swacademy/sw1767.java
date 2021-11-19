package swAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw1767 {
	static int N,map[][],cmax,cmin;
	static int dx[] ={1,0,-1,0};
	static int dy[] ={0,-1,0,1};//하 좌 상 우
	static boolean[][] visit;
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x =x;
			this.y =y;
		}
	
	}
	static ArrayList<dot> core;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			core = new ArrayList<>();
			for(int i=0;i<N;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1){
						if(i==0 || i==N-1|| j==0 || j == N-1){
							visit[i][j] = true;
							continue;
						}
						core.add(new dot(i,j));
					}
				}
			}
			cmax=-1;
			cmin=Integer.MAX_VALUE;
			dfs(0,0,0);
			System.out.println("#"+t+" "+cmin);
		}

	}
	private static void dfs(int index, int cnt, int len) { // index : core count, cnt : connect,len:전선길이
		if(index == core.size()){
			if(cmax<cnt){
				cmax = cnt;
				cmin = len;
			}else if(cmax == cnt){
				cmin = len>cmin?cmin:len;
			}
			return;
		}
		int x = core.get(index).x;
		int y = core.get(index).y;
		
		for(int dir=0;dir<4;dir++){
			int count=0;
			int nx = x;
			int ny = y;
			while(true){
				nx +=dx[dir];
				ny +=dy[dir];
				if(nx<0 || ny<0||nx>=N ||ny>=N)break; //벽이면 멈춤
				if(map[nx][ny]==1){
					count=0;
					break;
				}
				count++;//몇칸 가는지
			}
			int xx=x,yy=y;
			for(int i=0;i<count;i++){
				xx +=dx[dir];
				yy+=dy[dir];
				map[xx][yy] = 1; 
			}
			if(count == 0){
				dfs(index+1,cnt,len);
			}else{
				dfs(index+1,cnt+1,len+count);
				xx=x;
				yy=y;
				for(int i=0;i<count;i++){
					xx +=dx[dir];
					yy+=dy[dir];
					map[xx][yy] = 0; 
				}
			}
			
			
		}
		
	}

}
