package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj16398 {
	static int parents[];
	static PriorityQueue<edge> pq = new PriorityQueue<>();
	static class edge implements Comparable<edge>{
		int s,e,v;
		public edge(int s,int e,int v){
			this.e = e;
			this.s = s;
			this.v = v;
		}
		public int compareTo(edge e){
			return v-e.v;
		}
	}
	public static void union(int s, int e){
		int aRoot = find(s);
		int bRoot = find(e);
		
		if(aRoot != bRoot){
			parents[aRoot] = e;
		}else{
			return;
		}
	}
	private static int find(int s) {
		if(s == parents[s])return s;
		parents[s] = find(parents[s]);
		return parents[s];
	}
	static int n;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for(int i=1;i<=n;i++){
			parents[i] = i;
		}
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				int v = Integer.parseInt(st.nextToken());
				if(v!=0){
					pq.add(new edge(i+1,j+1,v));
				}
				
			}
		}
		long w =0;
		while(!pq.isEmpty()){
			edge eg = pq.poll();
			int a = find(eg.s);
			int b = find(eg.e);
			if(a==b) continue;
			
			if(eg.s != eg.e){
				union(eg.s,eg.e);
				w += eg.v;
			}
		}
		System.out.println(w);
	}

}
