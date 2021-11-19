package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17471 {
	static int n,div,min=Integer.MAX_VALUE,population[],c=0;
	static boolean area[];
	static ArrayList<Integer>[] connect;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n+1];
		connect = new ArrayList[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			connect[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt  = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				connect[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(connect[i]+ " :  ");
			for (int j = 0; j <connect[i].size(); j++) {
				System.out.print(connect[i].get(j)+" ");
			}System.out.println();
		}
		//부분집합
		for(int i=0;i<(n/2)+1;i++){
			div=i;
			area = new boolean[n+1];
			combination(1,0);
		}
		System.out.println(c);
		System.out.println(min ==Integer.MAX_VALUE?-1:min);
		

	}
	private static void combination(int start,int index) {
		if(div == index){c++;
			if(possible()){
				int sumA=0,sumB=0;
				for(int i=1;i<=n;i++){
					if(area[i]) sumA+=population[i];
					else sumB+=population[i];
				}
				min = Math.min(min, Math.abs(sumA-sumB));
			}
			return;
		}
		for(int i=start;i<n+1;i++){
			area[i] = true;
			combination(i+1, index+1);
			area[i] = false;
		}
		
	}
	private static boolean possible() {
		for(int i=1;i<=n;i++){
			System.out.print(area[i]+" ");
		}System.out.println();
		boolean[] visit = new boolean[n+1];
		int areaA = -1;
		for(int i=1;i<=n;i++){
			if(area[i]){
				areaA = i;
				break;
			}
		}
		int areaB = -1;
		for(int i=1;i<=n;i++){
			if(!area[i]){
				areaB = i;
				break;
			}
		}
		if(areaA == -1 || areaB==-1)return false;
		System.out.println(areaA+" "+areaB);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(areaA);
		visit[areaA] = true;
		while(!q.isEmpty()){
			int now = q.poll();
			for (int i = 0; i < connect[now].size(); i++) {
				if(visit[connect[now].get(i)])continue;
				if(!area[connect[now].get(i)])continue;
				visit[connect[now].get(i)] = true;
				q.add(connect[now].get(i));
				System.out.println("a: "+connect[now].get(i));
			}
		}
		
		q.add(areaB);
		visit[areaB] = true;
		while(!q.isEmpty()){
			int now = q.poll();
			for (int i = 0; i < connect[now].size(); i++) {
				if(visit[connect[now].get(i)])continue;
				if(area[connect[now].get(i)])continue;
				visit[connect[now].get(i)] = true;
				q.add(connect[now].get(i));
				System.out.println(connect[now].get(i));
			}
		}
		for(int i=1;i<=n;i++){
			if(!visit[i])return false;
		}
		return true;
	}

}
