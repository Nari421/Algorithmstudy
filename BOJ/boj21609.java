package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj21609 {
	static int n,m,map[][],max=0,rainbowCnt=0,score=0;
	static int dx[]={-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean[][] visit;
	static LinkedList<block> blocklist = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true){
			//make a block
			for(int t=1;t<=m;t++){
				visit = new boolean[n][n];
				max=0;
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(!visit[i][j] && map[i][j]==t){
							rainbowCnt=0;
							int size = makeBlock(i,j,t);
							if(size>1){
								blocklist.add(new block(t,rainbowCnt,i,j,size));
							}
							max = Math.max(size,max);
						}
					}
				}
			}
			if(blocklist.size() == 0){
				break;
			}
			Collections.sort(blocklist);
			for(block b:blocklist){
				System.out.println("index :"+b.x+" "+b.y+" rainbow : "+b.rainbow+" size: "+b.size+" color: "+b.num);
			}
			visit = new boolean[n][n];
			block b = blocklist.get(0);
			removeBlock(b);
			rotate();
			blocklist.clear();
			System.out.println("최종");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(map[i][j]+"\t");
				}System.out.println();
			}
			
		}
		System.out.println(score);
	}
	private static void rotate() {
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j] = map[j][n-i-1];
			}
		}
		map = arr;
		System.out.println("rotate:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+"\t");
			}System.out.println();
		}
		gravity();
		
	}
	private static void removeBlock(block b) {
		int x = b.x;
		int y = b.y;
		int color = b.num;
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(x,y,map[x][y]));
		visit[x][y] = true;
		map[x][y]=-2;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0 || ny<0|| nx>=n||ny>=n||visit[nx][ny]==true)continue;
				if(map[nx][ny]==0 || map[nx][ny]==color){
					visit[nx][ny]=true;
					q.add(new dot(nx,ny,color));
					map[nx][ny]=-2;
				}
			}
		}
		score+=Math.pow(b.size, 2);
		System.out.println("score: "+score);
		System.out.println("remove:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+"\t");
			}System.out.println();
		}
		gravity();
		
	}
	private static void gravity() {
		ArrayList<Integer> s;
		int index=0;
		for(int i=0;i<n;i++){
			s = new ArrayList<>();
			for(int j=0;j<n;j++){
				if(map[j][i] !=-1){
					s.add(map[j][i]);
					map[j][i] = -2;
				}
				else if(map[j][i] ==-1 && j!=0){
					start(j,i,s);
					s.clear();
				}
			}
			start(n,i,s);
		}
		
		System.out.println("gravtiy:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+"\t");
			}System.out.println();
		}
	}
	private static void start(int j, int i, ArrayList<Integer> s) {
		int size = s.size();
		j = j==0?n-1:j-1;
		while(size-- >0){
			if(s.get(size)==-2)continue;
			map[j--][i] = s.get(size);
		}
		
	}
	private static int makeBlock(int x, int y,int color) {
		Queue<dot> q = new LinkedList<>();
		LinkedList<dot> rainbow = new LinkedList<>();
		q.add(new dot(x,y,map[x][y]));
		visit[x][y] = true;
		int size=1;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0 || ny<0|| nx>=n||ny>=n||visit[nx][ny]==true)continue;
				if(map[nx][ny]==0){
					rainbow.add(new dot(nx,ny,0));
					size++;
					visit[nx][ny]=true;
					q.add(new dot(nx,ny,color));
				}else if(map[nx][ny]==color){
					size++;
					visit[nx][ny]=true;
					q.add(new dot(nx,ny,color));
				}
			}
		}
		rainbowCnt = rainbow.size();
		for(dot d:rainbow){
			visit[d.x][d.y]=false;
		}
		if(size<max){
			return -1;
		}
		if(size==1){
			return -1;
		}
		return size;
	}
	static class dot{
		int x,y,color;
		public dot(int x,int y,int color){
			this.x = x;
			this.y = y;
			this.color=color;
		}
		
	}
	static class block implements Comparable<block>{
		int num,rainbow,x,y,size;
		public block(int num,int rainbow,int x,int y,int size){
			this.x = x;
			this.y = y;
			this.num = num;
			this.rainbow = rainbow;
			this.size=size;
		}
		@Override
		public int compareTo(block b){
			if(this.size == b.size){
				if(this.rainbow == b.rainbow){
					if(this.x==b.x){
						return b.y-this.y;
					}return b.x-this.x;
				}else return b.rainbow-this.rainbow;
			}else return b.size-this.size;
			
		}
	}

}
