package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16918 {
	static int R,C,N;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean[][] visit;
	static char[][] map;
	static ArrayList<int[]> bomb =new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		bomb = new ArrayList<>();
		for(int i=0;i<R;i++){
			String s = br.readLine();
			for(int j=0;j<C;j++){
				map[i][j] = s.charAt(j);
				if(map[i][j]=='O'){
					bomb.add(new int[]{i,j});
				}
			}
		}
		if(N%2==0){
			for (int i = 0; i < R; i++) {
				String s ="";
				for (int j = 0; j < C; j++) {
					s+="O";
				}System.out.println(s);
			}
			return;
		}
		int cnt=2;
		while(cnt<=N){
			visit =new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]='O';
				}
			}
			if(cnt%2 ==1){
				for (int[] i:bomb) {
					startBomb(i[0],i[1]);
					map[i[0]][i[1]] = '.';
				}countBomb();
			}
			
			
			cnt++;
		}
		for (int i = 0; i < R; i++) {
            String s = "";
			for (int j = 0; j < C; j++) {
				s+=map[i][j]+"";
			}System.out.println(s);
		}
		
		
	}

	private static void countBomb() {
		bomb = new ArrayList<>();
		Queue<int[]> q = new LinkedList<int[]>();
		if(map[0][0]=='O'){
			bomb.add(new int[]{0,0});
		}
		q.add(new int[]{0,0});
		visit[0][0] = true;
		while(!q.isEmpty()){
			int[] orgin = q.poll();
			for(int i=0;i<4;i++){
				int nx = orgin[0]+dx[i];
				int ny = orgin[1]+dy[i];
				if(nx<0 || ny<0||nx>=R ||ny>=C || visit[nx][ny]==true)continue;
				if(map[nx][ny]=='O' && !visit[nx][ny]){
					bomb.add(new int[]{nx,ny});
				}
				visit[nx][ny] = true;
				q.add(new int[]{nx,ny});
			}
		}
	}

	private static void startBomb(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (map[nx][ny] == 'O') {
				map[nx][ny] = '.';
			}
		}
	}
	private static void setAllBomb() {
		bomb = new ArrayList<>();
		Queue<int[]> q = new LinkedList<int[]>();
		if(map[0][0]=='.'){
			map[0][0]='O';
		}else if(map[0][0]=='O'){
			map[0][0]='X';
			bomb.add(new int[]{0,0});
		}
		q.add(new int[]{0,0});
		visit[0][0] = true;
		while(!q.isEmpty()){
			int[] orgin = q.poll();
			for(int i=0;i<4;i++){
				int nx = orgin[0]+dx[i];
				int ny = orgin[1]+dy[i];
				if(nx<0 || ny<0||nx>=R ||ny>=C || visit[nx][ny]==true)continue;
				if(map[nx][ny]=='.' && !visit[nx][ny]){
					map[nx][ny]='O';
				}else if(map[nx][ny]=='O' && !visit[nx][ny]){
					map[nx][ny]='X';
					bomb.add(new int[]{nx,ny});
				}
				visit[nx][ny] = true;
				q.add(new int[]{nx,ny});
			}
		}
		
	}

}
