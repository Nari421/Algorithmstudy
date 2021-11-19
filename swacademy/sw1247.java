package swAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class sw1247 {
	static int N,company[],house[],min;
	static class dot{
		int x,y;
		public dot(int x,  int y){
			this.x = x;
			this.y = y;
		}
	}
	static boolean[] visit;
	static LinkedList<dot> customer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++){
			N = Integer.parseInt(br.readLine());
			company = new int[2];house = new int[2];
			visit = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			house[0] =Integer.parseInt(st.nextToken());
			house[1]=Integer.parseInt(st.nextToken());
			customer = new LinkedList<>();
			for(int i=0;i<N;i++){
				int x = Integer.parseInt(st.nextToken());
				int y =Integer.parseInt(st.nextToken());
				customer.add(new dot(x,y));
			}
			min = Integer.MAX_VALUE;
			permutation(0,0,company[0],company[1]);
			
			System.out.println("#"+(t+1)+" "+min);
		}
		
	}
	private static void permutation(int index, int start,int x,int y) {
		if(min<=start)return;
		if(index==N){
			int d = Math.abs(house[0]-x)+Math.abs(house[1]-y);
			start+=d;
			min = min>start?start:min;
			return;
		}
		for(int i=0;i<N;i++){
			if(!visit[i]){
				visit[i] = true;
				int d = Math.abs(customer.get(i).x-x)+Math.abs(customer.get(i).y-y);
				permutation(index+1, start+d,customer.get(i).x,customer.get(i).y);
				visit[i] = false;
			}
		}
		
	}
}
