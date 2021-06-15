package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static class Dot{
        int x;
        int y;
        Dot(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;
    static int N,M,answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(boolean a[] : visit){
            Arrays.fill(a,false);
        }
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j)-48;
            }
        }

        visit[0][0] = true;
        bfs(0 ,0);
        System.out.println(map[N-1][M-1]);
    }
    public static void bfs(int x, int y){
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x,y));

        while(!q.isEmpty()){
            Dot d = q.poll();
            for(int i=0;i<4;i++){
                int nx = d.x+dx[i];
                int ny = d.y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(visit[nx][ny] == false && map[nx][ny] ==1){
                        q.add(new Dot(nx,ny));
                        map[nx][ny] = map[d.x][d.y]+1;
                        visit[nx][ny] = true;
                    }
                }
            }
        }

    }
}
