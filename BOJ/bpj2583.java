package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bpj2583 {
	static int m,n,k,map[][],answer=0;
	static boolean visit[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static class Dot{
		int x,y;
		public Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		for(int[] a:map){
			for(int i:a){
				Arrays.fill(a, 0);
			}
		}
		int x,y,r_x,r_y;
		for(int i=0;i<k;i++){
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			r_y = Integer.parseInt(st.nextToken())-1;
			r_x = Integer.parseInt(st.nextToken())-1;
			map[x][y] =1;
			map[r_x][r_y]=1;
			movesquare(x,y,r_x,r_y);
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(" "+map[i][j]+" ");
			}System.out.println();
		}
		visit=new boolean[m][n];
		int sep=0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(visit[i][j] ==false && map[i][j] == 0){
					sep++;
					visit[i][j]=true;
					list.add(dfs(i,j,1));
				}
			}
		}
		System.out.println(sep);
		list.sort(null);
		for(int i=0;i<list.size();i++){
			if(i == list.size()-1){
				System.out.print(list.get(i));
				break;
			}System.out.print(list.get(i)+" ");
		}
	}
	private static void movesquare(int x, int y, int r_x, int r_y) {
		for(int i=x;i<=r_x;i++){
			for(int j=y;j<=r_y;j++){
				map[i][j] = 1;
			}
		}
		
	}
	private static Integer dfs(int x, int y,int sum) {
		visit[x][y] = true;
		answer=sum;
		for(int i=0;i<4;i++){
			int nx = x +dx[i];
			int ny = y+ dy[i];
			if(nx<0 || ny<0 || nx>=m || ny>= n)continue;
			if(visit[nx][ny]==false && map[nx][ny]==0){
				dfs(nx,ny,answer+1);
			}
		}
		return answer;
	}

}
