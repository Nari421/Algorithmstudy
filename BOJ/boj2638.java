package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2638 {
	static int N, M;
    static int[][] map;
    static int[][] air;
    static boolean[][] visited;
    static int cheeseCnt;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)cheeseCnt++;
            }
        }
        
        int time=0;
        while(cheeseCnt !=0){
        	time++;
        	bfs();
        }
        System.out.println(time);
    }

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{0,0});
		visited = new boolean[N][M];
		air = new int[N][M];
		for(int[] i:air){
			Arrays.fill(i, 0);
		}
		while(!q.isEmpty()){
			int[] d = q.poll();
			for(int  i=0;i<4;i++){
				int nx = d[0]+dx[i];
				int ny = d[1]+dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
				
				if(!visited[nx][ny]){
					if(map[nx][ny] ==1){
						air[nx][ny]+=1;
					}else if(map[nx][ny]==0){
						q.add(new int[]{nx,ny});
					}
				}else if(visited[nx][ny]){
					if(map[nx][ny] ==1 && air[nx][ny]==1){
						cheeseCnt--;
						map[nx][ny] = 0;
					}
				}
				visited[nx][ny] = true;
			}
		}
		
	}
}
