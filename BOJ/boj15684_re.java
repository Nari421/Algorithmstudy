package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class boj15684_re {

	static int N,M,H,a,b,answer=4;
	static boolean line[][],copyed[][];
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static LinkedList<dot> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		line = new boolean[H+1][N+2];
		copyed = new boolean[H+1][N+1];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			line[a][b] = true;
		}
		setLine(1,0);
		System.out.println("answer: "+answer);
		
	}
	private static void setLine(int row, int cnt) {
		if(cnt>0 && 3>=cnt){
			list.clear();
			copyLine();
			for(int i=1;i<N+1;i++){
				int tmp = startgame(i);
				System.out.println(tmp);
				if(i != tmp)return;
			}
			answer = cnt<answer?cnt:answer;
			return;
		}else if(cnt>3){
			System.out.println(-1);
			return;
		}
		for(int i=row;i<H+1;i++){
			for(int j=1;j<N+1;j++){
				if(!line[i][j-1] && !line[i][j] && !line[i][j+1]){
					line[i][j] = true;
					setLine(i,cnt+1);
					line[i][j] = false;
				}
			}
		}
	}
	private static int startgame(int start) {
		System.out.println("==============================");
		for(dot d:list){
			System.out.println(d.x+" ,"+d.y);
		}
		int end = start;
		for(int i=1;i<H+1;i++){
			for(int j=0;j<list.size();j++){
				if(list.get(j).x==i){
					if(list.get(j).y == start-1){//왼쪽
						start =list.get(j).y;
					}else if(list.get(j).y == start){//오른쪽
						start = list.get(j).y+1;
					}
				}
			}
		}
		if(start == end){
			return end;
		}
		else
			return -1;
		
	}
	private static void copyLine() {
		for(int i=0;i<H+1;i++){
			for(int j=0;j<N+1;j++){
				copyed[i][j] = line[i][j];
				if(copyed[i][j]==true)list.add(new dot(i,j));
			}
		}
	
	}

}
