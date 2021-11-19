package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj17144 {
	static int R,C,T,map[][];
	static class dot{
		int x,y;
		public dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static ArrayList<dot> robot = new ArrayList();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0;i<R;i++){
			st  = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1){
					robot.add(new dot(i,j));
				}
			}
		}
		
		while(T-- >0){
			int[][] copy = new int[R][C];
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					if(map[i][j] == -1){
						copy[i][j] = -1;
						continue;
					}
					int spread = map[i][j]/5;
					int cnt=0;
					for(int k=0;k<4;k++){
						int nr = i+dx[k];
						int nc = j+dy[k];
						if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc]==-1)continue;
						copy[nr][nc] += spread;
						cnt++;
					}copy[i][j] += map[i][j]-(spread*cnt);
				}
			}
			//위 아래 순환
			dot d = robot.get(0);
			circulationUp(d.x, d.y, copy);
			d = robot.get(1);
			circulationDown(d.x, d.y, copy);
			
//			for(int i=0;i<R;i++){
//				for(int j=0;j<C;j++){
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
//			
		}
		int answer=0;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(map[i][j]==-1)continue;
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
		
	}
	private static void circulationUp(int x, int y, int[][] copy) {
		//0,0,d.x,C-1
		int startx = x,starty=y;
		int cnt= (Math.abs(x-0)+ Math.abs((C-1)-0))*2-1;
		int rotate =0;
		int next=0;
		y++;//공기 청정기 다음 
		while(cnt-- >0){
			switch(rotate){
			case 0:
				int tmp = copy[x][y];//2
				copy[x][y++] = next;
				next = tmp;
				if(y == C-1){
					rotate=1;
				}
				break;
			case 1:
				tmp = copy[x][y];
				copy[x--][y] = next;
				next = tmp;
				if(x == 0){
					rotate=2;
				}
				break;
			case 2:
				tmp = copy[x][y];
				copy[x][y--] = next;
				next = tmp;
				if(y == 0){
					rotate=3;
				}
				break;
			case 3:
				tmp = copy[x][y];
				copy[x++][y] = next;
				next = tmp;
				if(x == startx){
					rotate=0;
				}
				break;
			}
		}
		copy[startx][starty] = -1;
		for(int i=0;i<R;i++){
			System.arraycopy(copy[i], 0, map[i], 0, C);
		}

	}
	private static void circulationDown(int x, int y, int[][] copy) {
		//d.x,0,R-1,C-1
		int startx = x,starty=y;
		int cnt  = (Math.abs((R-1)-x)+Math.abs((C-1)-0))*2-1;
		int rotate =0;
		int next=0;
		y++;
		while(cnt-- >0){
			switch(rotate){
			case 0:
				int tmp = copy[x][y];//2
				copy[x][y++] = next;
				next = tmp;
				if(y == C-1){
					rotate=1;
				}
				break;
			case 1:
				tmp = copy[x][y];
				copy[x++][y] = next;
				next = tmp;
				if(x == R-1){
					rotate=2;
				}
				break;
			case 2:
				tmp = copy[x][y];
				copy[x][y--] = next;
				next = tmp;
				if(y == 0){
					rotate=3;
				}
				break;
			case 3:
				tmp = copy[x][y];
				copy[x--][y] = next;
				next = tmp;
				if(x == startx){
					rotate=0;
				}
				break;
			
			}
		}
		copy[startx][starty] = -1;
		for(int i=0;i<R;i++){
			System.arraycopy(copy[i], 0, map[i], 0, C);
		}
	}

}
