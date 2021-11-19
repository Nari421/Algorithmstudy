package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1941 {
	static char map[][];
	static boolean visit[];
	static int cnt=0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i=0;i<5;i++){
			String s = br.readLine();
			for(int j=0;j<5;j++){
				map[i][j] = s.charAt(j);
			}
		}
		visit = new boolean[25];
		combination(0,0);
		System.out.println(cnt);

	}
	private static void combination(int index, int start) {
		if(index==7){
			//칠공주 인지 찾기
			int s_count=0;
			int first =0;
			int x=0,y=0;
			int[][] map2 = new int[5][5];
			for(int i=0;i<25;i++){
				if(visit[i] == true){
					int row = i/5;
					int col = i%5;
					map2[row][col] = 1;
					if(first == 0){
						x = row;
						y = col;
						first++;
					}
					if(map[row][col] == 'S')s_count++;
					if(first==7)break;
				}
			}
			if(s_count>=4){
				bfs(x,y,map2);
			}
			return;
		}
		for(int i=start;i<25;i++){
			if(!visit[i]){
				visit[i]=true;
				combination(index+1, i);
				visit[i] = false;
			}
		}
		
	}
	private static void bfs(int x, int y, int[][] map2) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		boolean[][] visited = new boolean[5][5];
		int[] dx = {1,-1,0,0};
		int[] dy ={0,0,1,-1};
		int s_count=0;
		while(!q.isEmpty()){
			int[] d = q.poll();
			for(int i=0;i<4;i++){
				int nx = d[0]+dx[i];
				int ny = d[1]+dy[i];
				if(nx<0||ny<0||nx>=5||ny>=5)continue;
				if(map2[nx][ny] == 1 && visited[nx][ny] ==false){
					q.add(new int[]{nx,ny});
					s_count++;
					visited[nx][ny] = true;
				}
			}
		}
		if(s_count == 7){
			cnt++;
		}
		
	}

}
