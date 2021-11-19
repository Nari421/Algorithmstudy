package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20057 {
	static int n,a[][],out=0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][] movex = {{-1,1,-2,-1,1,2,-1,1,0,0}, {-1,-1,0,0,0,0,1,1,2,-1},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0,0}, {1,1,0,0,0,0,-1,-1,-2,1}};
	static int[][] movey = {{1,1,0,0,0,0,-1,-1,-2,-1},{-1,1,-2,-1,1,2,-1,1,0,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2,1},{1,-1,2,1,-1,-2,1,-1,0,0}};
	static int[] percent ={1,1,2,7,7,2,10,10,5};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move();
		
		System.out.println(out);
	}
	private static void move() {
		int sx = n/2;
		int sy = n/2;
		int tx= sx;
		int ty = sy;
		int dir=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<i+1;k++){
					tx +=dx[dir];
					ty+=dy[dir];
					if(tx<0||ty<0||tx>=n||ty>=n)continue;
					wind(tx,ty,dir);
					if(tx==0 && ty ==0)return;
				}dir=dir==3?0:dir+1;
			}
			
		}
	}
	private static void wind(int tx, int ty, int dir) {
		int now = a[tx][ty];
		int outSend=0;
		for(int i=0; i<9; i++) {
			//모래가 옮겨질 좌표
			int sx=tx+movex[dir][i];
			int sy=ty+movey[dir][i];
			int plusSend=(int)(now*((double)percent[i]/100));
			
			if(sx<0|| sy<0|| sx>=n || sy>=n) {
				out+=plusSend; //밖으로 나가는거
			}else{
				a[sx][sy]+=plusSend; //밖으로 안나가면 그 좌표에 더해줌 
			}
			outSend+=plusSend;
		}
		int subx = tx+dx[dir];
		int suby = ty+dy[dir];
		int subAmount = now - outSend;
		if(subx<0 || subx>=n|| suby<0|| suby>=n){
            out +=subAmount;
        }
        else{
            a[subx][suby] +=subAmount;
        }
		a[tx][ty]=0;
		
	}

}
