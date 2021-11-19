package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj21608 {
	static int n,answer=0,empty[][],seat[][],order[],friends[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static HashMap<Integer, int[]> info = new HashMap<>();
	static PriorityQueue<dot> priority ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		empty=new int[n][n];
		seat = new int[n][n];
		order = new int[n*n];
		friends = new int[n*n][4];
		for(int i=0;i<n*n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			order[i] = key;
			for(int j=0;j<4;j++){
				friends[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		emptySeat();
		//학생 자리 앉기
		for(int i=0;i<n*n;i++){
			priority = new PriorityQueue<dot>();
			findSeat(i);
			dot d = priority.poll();
			seat[d.x][d.y] =order[i];
			info.put(order[i],new int[]{d.x,d.y});
			for(int j=0;j<4;j++){
				int nx = d.x+dx[j];
				int ny = d.y+dy[j];
				if(nx<0 || ny<0|| nx>=n ||ny>=n )continue;
				empty[nx][ny]--;
			}
			
		}
		int prefer=0;
		for(int i=0;i<n*n;i++){
			int x = info.get(order[i])[0];
			int y = info.get(order[i])[1];
			int cnt=0;
			for(int j=0;j<4;j++){
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(nx<0 || ny<0|| nx>=n ||ny>=n )continue;
				for(int k=0;k<4;k++){
					if(friends[i][k]==seat[nx][ny]){
						cnt++;break;
					}
				}
			}
			if(cnt==1)prefer+=1;
			else if(cnt==2)prefer+=10;
			else if(cnt==3)prefer+=100;
			else if(cnt==4)prefer+=1000;
		}
		System.out.println(prefer);
//		for(int i=0;i<n;i++){
//			for(int j=0;j<n;j++){
//				int likes=0;
//				for(int k=0;k<4;k++){
//					int nx = i+dx[k];
//					int ny = j+dy[k];
//					if(nx<0 || ny<0|| nx>=n ||ny>=n )continue;
//					
//				}
//			}
//		}
		
	}
	private static void findSeat(int myseat) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(seat[i][j] !=0)continue;
				
				dot d = new dot(i,j,empty[i][j],0);
				int likes=0;
				for(int k=0;k<4;k++){
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || ny<0|| nx>=n ||ny>=n || seat[nx][ny]==0)continue;
					
					for(int kk=0;kk<4;kk++){
						if(friends[myseat][kk] == seat[nx][ny]){
							likes++;
							break;
						}
					}
				}
				d.like = likes;
				priority.add(d);
			}
		}
		
	}
	private static void emptySeat() {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int cnt=4;
				if(i==0 || i==n-1)--cnt;
				if(j==0 || j==n-1)--cnt;
				empty[i][j] = cnt;
			}
		}
	}
	
	static class dot implements Comparable<dot>{
		int x,y,empty,like;
		public dot(int x, int y,int empty,int like){
			this.x = x;
			this.y = y;
			this.empty= empty;
			this.like = like;
		}
		@Override
		public int compareTo(dot d){
			if (this.like == d.like){
                if (this.empty == d.empty){
                    if (this.x == d.x) return this.y - d.y;
                    else return this.x - d.x;
                }
                else return d.empty - this.empty;
            }
            else return d.like - this.like; //내림 차순
			
		}
	}

}
