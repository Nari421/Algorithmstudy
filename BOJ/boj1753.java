package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
	static class Dot implements Comparable<Dot>{
		int y,w;
		public Dot(int y,int w){
			this.y = y;
			this.w=w;
		}
		@Override
		public int compareTo(Dot d){
			return w-d.w;
		}
	}
	static int V,E,weight[];
	static ArrayList<Dot>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		weight = new int[V+1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		list = new ArrayList[V+1];
		int start = Integer.parseInt(br.readLine());
		for(int i=1;i<=V;i++){
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++){
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			list[x].add(new Dot(y,w));
		}
		weight[start]=0;
		dijkstra(start);
		for(int i=1;i<=V;i++){
			if(weight[i]==Integer.MAX_VALUE){
				System.out.println("INF");
			}else{
				System.out.println(weight[i]);
			}
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Dot> q = new PriorityQueue<>();
		q.add(new Dot(start,0));
		while(!q.isEmpty()){
			Dot d = q.poll();
			int ver = d.y;
			int we = d.w;
			if(weight[ver]<we)continue;
			for(int i=0;i<list[ver].size();i++){
				int next = list[ver].get(i).y;
				int value = list[ver].get(i).w;
				if(weight[next]>value+we){
					weight[next]=value+we;
					q.add(new Dot(next,value+we));
				}
			}
		}
		
	}

}
