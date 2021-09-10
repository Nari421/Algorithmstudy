package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17472 {
	static int n,m,answer=0,land=1,cnt=0,result=0,bridge_count=0;
	static int map[][],parents[];
	static PriorityQueue<edge> connect = new PriorityQueue<edge>();
	static boolean visit[][];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static class dot{
		int x,y,l;
		public dot(int x,int y,int l){
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		//땅 구분
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(map[i][j]==1 && !visit[i][j]){
					bfs(i,j);
					land++;
				}
			}
		}
		
		//다리 연결
		for(int i=0;i<n;i++){
			for (int j = 0; j < m; j++) {
				if(map[i][j]!=0){
					dot d = new dot(i,j,map[i][j]);
					bridge(d);
				}
			}
		}
		parents = new int[land];
        for(int i=0; i<parents.length; i++) {
            parents[i] = i;
        }
        
        int size = connect.size();
        for(int i=0; i<size; i++) {
            edge tmp = connect.poll();
                        
            int a = find(tmp.s);
            int b = find(tmp.e);
            
            if(a==b) continue;
            
            union(tmp.s, tmp.e);
            result += tmp.v;
            bridge_count++;
        }
        //result == 0 이거나 다리의 개수가 섬의 개수 - 1이 아니면 -1을 출력한다.
        if(result == 0 || bridge_count != land-2) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
		
		
	}
	private static void bridge(dot origin) {
		Queue<dot> q = new LinkedList<>();
		for(int i=0;i<4;i++){
			q.add(new dot(origin.x,origin.y,origin.l));
			cnt=0;
			while(!q.isEmpty()){
				dot d = q.poll();
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx>=0 &&  ny>=0 && nx<n && ny<m){
					if(map[nx][ny]==0){
						++cnt;
						q.add(new dot(nx,ny,origin.l));
					}else if(map[nx][ny] != origin.l && cnt>1){
						connect.add(new edge(origin.l,map[nx][ny],cnt));
						//System.out.println(origin.l+" "+map[nx][ny]+" "+cnt);
					}
				}
			}
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(x,y,land));
		visit[x][y]=true;
		map[x][y]=land;
		while(!q.isEmpty()){
			dot d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=m)continue;
				if(!visit[nx][ny] && map[nx][ny]==1){
					visit[nx][ny] = true;
					map[nx][ny]=land;
					q.add(new dot(nx,ny,land));
				}
			}
		}
		
	}
	public static int find(int a) {
        if(a == parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }
    
    public static void union(int s,int e) {
        int aRoot = find(s);
        int bRoot = find(e);
        
        if(aRoot != bRoot) {
            parents[aRoot] = e;
        } else {
            return;
        }
    }
	static class edge implements Comparable<edge> {
	    int s;
	    int e;
	    int v;
	    
	    public edge(int s,int e,int v) {
	        super();
	        this.s = s;
	        this.e = e;
	        this.v = v;
	    }
	 
	    @Override
	    public int compareTo(edge arg0) {
	        return arg0.v >= this.v ? -1:1;
	    }
	}

}
