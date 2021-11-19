package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj20056 {
	static int dr[] ={-1,-1,0,1,1,1,0,-1};
	static int dc[] ={0,1,1,1,0,-1,-1,-1};
	static class ball{
		int r,c,m,s,d;
		public ball(int r, int c, int m,int s, int d){
			this.c= c;
			this.d = d;
			this.m = m;
			this.r = r;
			this.s=s;
		}
	}
	static int answer=0,N,M,K;
	static ArrayList<ball>[][] fire;
	static ArrayList<ball> order = new ArrayList();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		fire = new ArrayList[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				fire[i][j] = new ArrayList<ball>();
			}
		}
		for(int i=0;i<M;i++){
			 st = new StringTokenizer(br.readLine());
			 int r =Integer.parseInt(st.nextToken())-1;
			 int c =Integer.parseInt(st.nextToken())-1;
			 int m =Integer.parseInt(st.nextToken());
			 int s =Integer.parseInt(st.nextToken());
			 int d =Integer.parseInt(st.nextToken());
			 order.add(new ball(r,c,m,s,d));
		}
		while(K-- >0){
			int size = order.size();
			while(size-- >0){
				ball b = order.get(size);
				movefireball(b);
			}
			countM();
		}
		for(ball b:order){
			answer+=b.m;
		}
		System.out.println(answer);

	}
	private static void countM() {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(fire[i][j].size()==1){
					fire[i][j].clear();
				}
				if(fire[i][j].size()<2)continue;
				
				int weight=0,speed=0;
				int even=0,odd=0;
				int size= fire[i][j].size();
				for(ball b : fire[i][j]){
					weight+=b.m;
					speed+=b.s;
					even = (b.d%2==0)?even+=1:even;
					odd = (b.d%2==1)?odd+=1:odd;
					order.remove(b);
				}
				int newWeight = weight/5;
				fire[i][j].clear();
				if(newWeight==0)continue;
				int newSpeed = speed/size;
				if(even == size || odd == size){
					for(int k=0;k<8;k+=2){
						order.add(new ball(i,j,newWeight,newSpeed,k));
					}
				}else{
					for(int k=1;k<8;k+=2){
						order.add(new ball(i,j,newWeight,newSpeed,k));
					}
				}
			}
		}
	}
	private static void movefireball(ball b) {
		int nr = (b.r+N+dr[b.d]*(b.s%N))%N;
		int nc = (b.c+N+dc[b.d]*(b.s%N))%N;
		b.r = nr;
		b.c = nc;
		fire[nr][nc].add(b);
	}

}
