package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj17837 {
	static int n,k,color[][];
	static int dr[] = {0,0,-1,1};//우 좌 위 아래
	static int dc[] = {1,-1,0,0};
	static class Point{
		int id,r,c,d;
		public Point(int id, int r,int c,int d){
			this.id = id;
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	//0은 흰색, 1은 빨간색, 2는 파란색
	static ArrayList<Point> point = new ArrayList<>();
	static ArrayList<Integer>[][] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		color = new int[n+1][n+1];
		chess = new ArrayList[n+1][n+1];
		point.add(new Point(0,0,0,0));
		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				chess[i][j] = new ArrayList<>();
			}
		}
		for(int i=1;i<=k;i++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			point.add(new Point(i,r,c,d-1));
			chess[r][c].add(i);
		}
		startGame();
	}
	private static void startGame() {
		int times =0;
		while(times<=1000){
			times++;
			for(int i=1;i<=k;i++){
				if(move(i)){
					System.out.println(times);
					return;
				}
			}
		}
		System.out.println(-1);
		
	}
	private static boolean move(int i) {
		Point p  = point.get(i);
		int nr = p.r+dr[p.d];
		int nc = p.c+dc[p.d];
		if(nr>n || nc>n || nr<1||nc<1 || color[nr][nc] == 2){
			//방향 바꿔주기
			if(p.d%2 == 0){
				point.set(i, new Point(i,p.r,p.c,p.d+1));
			}else{
				point.set(i, new Point(i,p.r,p.c,p.d-1));
			}
			p  = point.get(i);
			nr = p.r+dr[p.d];
			nc = p.c+dc[p.d];
		}
		if(nr<=n && nc<=n && nr>=1 && nc>=1 && color[nr][nc] != 2){
			checkcolor(p,nr,nc);
			if(chess[nr][nc].size() >=4)return true;
		}
			
		return false;
	}
	private static void checkcolor(Point p, int nr, int nc) {
		ArrayList<Integer> from = chess[p.r][p.c];
		ArrayList<Integer> to = chess[nr][nc];
		
		int stack =from.indexOf(p.id); // 체스판에 몇개;
		int fromsize = from.size();
		int tosize = to.size();
		switch(color[nr][nc]){
		case 0:
			for(int i=stack;i<fromsize;i++){
				int po = from.get(i);
				int d = point.get(po).d;
				point.set(po,new Point(po,nr,nc,d));
				p = point.get(po);
				to.add(po);
			}
			remove(from,fromsize-1,stack);
			break;
		case 1:
			for(int i=fromsize-1;i>=stack;i--){
				int po = from.get(i);
				int d = point.get(po).d;
				point.set(po,new Point(po,nr,nc,d));
				p = point.get(po);
				to.add(po);
			}
			remove(from,fromsize-1,stack);
			break;
		}
		
	}
	private static void remove(ArrayList<Integer> list, int top, int bottom) {
		for(int i = top ; i >= bottom ; --i) {
			list.remove(i);
		}
	}

}
