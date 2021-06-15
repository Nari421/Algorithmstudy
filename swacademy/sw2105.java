package boj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw2105 {
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,1,-1};
	static int n=0,cnt=0,max=-1;
	static int[][] map;
	static boolean[][] visit;
	static HashSet<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			n = sc.nextInt();
			map = new int[n][n];
			visit = new boolean[n][n];
			list=new HashSet();
			max=-1;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<n-2;i++){
				for(int j=1;j<n-1;j++){
					init();
					list.add(map[i][j]);
					visit[i][j]=true;
					tourD(i,j,i,j,0);
					visit[i][j] = false;
					list.remove(map[i][j]);
				}
			}
			System.out.println("#" + test_case + " " + max);
			
		}

	}
	
	private static void init() {
		for(boolean[] b : visit){
			for(boolean a:b){
				Arrays.fill(b,false);
			}
		}
		list.clear();
	}

	private static void tourD(int mx, int my,int sx, int sy,int dir) {
		for(int i=dir;i<4;i++){
			int nx = mx+dx[i];
			int ny = my+dy[i];
			
			if(list.size()>=3 && nx==sx && ny==sy){
				cnt = list.size();
				max = cnt>max?cnt:max;
				return;
			}
			if(nx<0 || nx>=n || ny<0 || ny>=n || visit[nx][ny]==true)continue;
			if(list.contains(map[nx][ny]))continue;
			
			visit[nx][ny] = true;
			list.add(map[nx][ny]);
			tourD(nx,ny,sx,sy,i);
			visit[nx][ny]=false;
			list.remove(map[nx][ny]);
			
		}
	}
	

}
