package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1197 {
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		for(int i=1;i<=V;i++){
			parents[i] = i;
		}
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.add(new edge(s,e,v));
		}
		int w =0;
		while(!pq.isEmpty()){
			edge eg = pq.poll();
			if(find(eg.s) !=find(eg.e)){
				union(eg.s,eg.e);
				w+=eg.v;
			}
		}
		System.out.println(w);

	}

}
