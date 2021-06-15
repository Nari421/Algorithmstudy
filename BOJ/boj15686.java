package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj15686 {
	static int n,m,city[][],answer=Integer.MAX_VALUE,dept=0;
	static boolean visit[];
	static class Dot{
		int r,c;
		public Dot(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static LinkedList<Dot> chicken = new LinkedList<>();
	static LinkedList<Dot> house = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		city = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++){
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1){
					house.add(new Dot(i,j));
				}else if(city[i][j]==2){
					chicken.add(new Dot(i,j));
				}
			}
		}
		visit = new boolean[chicken.size()];
		Arrays.fill(visit, false);
		for(int i=1;i<=m;i++){
			dept = i;
			setChicken(0,0);
		}
		System.out.println(answer);
		
	}
	private static void setChicken(int start, int cnt) {
		if(dept==cnt){
			answer = Math.min(answer, distance());
			return;
		}
		for(int i=start ;i<visit.length;i++){
			if(visit[i] == false){
				visit[i] = true;
				setChicken(i, cnt+1);
				visit[i] = false;
			}
		}
	}
	private static int distance() {
		int sum=0,total=0;
		for(int i=0;i<house.size();i++){
			sum =Integer.MAX_VALUE;
			for(int j=0;j<visit.length;j++){
				if(visit[j] == true){
					int tmp = Math.abs(house.get(i).r-chicken.get(j).r)+Math.abs(house.get(i).c-chicken.get(j).c);
					sum = tmp<sum?tmp:sum;
				}
			}total+=sum;
		}
		if(total>answer)return total;
		
		return total;
	}
	

}
