package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj15686_re {
	static int n,m,h,map[][],answer=Integer.MAX_VALUE;
	static boolean chic[];
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x =x;
			this.y = y;
		}
	}
	static LinkedList<dot> chicken = new LinkedList<>();
	static LinkedList<dot> house = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1){
					house.add(new dot(i,j));
				}else if(map[i][j] == 2){
					chicken.add(new dot(i,j));
				}
			}
		}
		chic = new boolean[chicken.size()];
		for(int i=1;i<=m;i++){
			findmin(i,0,0);
		}
		System.out.println(answer);
	}
	private static void findmin(int index, int start, int cnt) {
		if(index == cnt){
			answer = Math.min(calc(),answer);
			return;
		}
		for(int i=start;i<chic.length;i++){
			if(chic[i] == false){
				chic[i] = true;
				findmin(index,i,cnt+1);
				chic[i] = false;
			}
		}
		
	}
	private static int calc() {
		int sum=0,total=0;
		for (int i = 0; i < house.size(); i++) {
			sum = Integer.MAX_VALUE;
			for (int j = 0; j < chic.length; j++) {
				if(chic[j] == true){
					int dist = Math.abs(chicken.get(j).x -house.get(i).x)+Math.abs(chicken.get(j).y -house.get(i).y);
					sum = dist<sum?dist:sum;
				}
			}total+=sum;
		}
		return total;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
