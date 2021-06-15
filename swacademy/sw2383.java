package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw2383 {
	static int t,n,map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static class person implements Comparable<person>{
		int s,p,m;
		public person(int s, int p, int m){
			this.s = s;
			this.p = p;
			this.m = m;
		}
		public int getM(){
			return this.m;
		}
		@Override
	    public int compareTo(person p) {
	        if (this.m <p.getM()) {
	            return -1;
	        } else if (this.m > p.getM()) {
	            return 1;
	        }
	        return 0;
	    }

	}
	static class dot{
		int x,y;
		public dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int test=1;test<=t;test++){
			n = Integer.parseInt(br.readLine());
			map = new int[n+1][n+1];
			int[][] stair = new int[2][2];
			int s=0;
			LinkedList<dot> per = new LinkedList<>();
			for(int j=1;j<=n;j++){
				StringTokenizer st  = new StringTokenizer(br.readLine());
				for(int k=1;k<=n;k++){
					map[j][k] = Integer.parseInt(st.nextToken());
					if(map[j][k] == 1){
						per.add(new dot(j,k));
					}else if(map[j][k] >1){
						stair[s][0]=j;
						stair[s][1]=k;
						s++;
					}
				}
			}//입력 끝
			
			LinkedList<person> info1 = new LinkedList<>();
			LinkedList<person> info2 = new LinkedList<>();
			for(int i=0;i<per.size();i++){
				int s1=Math.abs(per.get(i).y-stair[0][1])+Math.abs(per.get(i).x-stair[0][0]);
				int s2=Math.abs(per.get(i).y-stair[1][1])+Math.abs(per.get(i).x-stair[1][0]);
				if(s1<s2){
					info1.add(new person(1,i+1,s1));
				}else{
					info2.add(new person(2,i+1,s2));
					System.out.println(s2);
				}
			}
			Collections.sort(info1);
			Collections.sort(info2);
			
			for(int i=0;i<2;i++){
				int wait = map[stair[i][0]][stair[i][1]];
				int cnt=0,time=0;
				while(true){
					for(int j=0;j<info1.size();j++){
						if(time==info1.get(i).m){
							if(cnt<3){
							
							}
						}
					}
				}
				
			}
			
		}
	}
	private static int bfs(int sx, int sy,int x,int y) {
		
		return 0;
	}

}
