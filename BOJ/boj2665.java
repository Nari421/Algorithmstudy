package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2665 {
    static int n;
    static int[][] visit;
    static int[][] map;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static class Dot{
        int x;
        int y;
        public Dot(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new int[n][n];
        map = new int[n][n];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j)-48;
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0,0);
        System.out.println(visit[n-1][n-1]);
    }
    static void bfs(int x,int y){
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x,y));
        visit[0][0] = 0;

        while (!q.isEmpty()){
            Dot d = q.poll();
            for(int i=0;i<4;i++){
                int nx = d.x+dx[i];
                int ny = d.y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n)continue;

                if(visit[nx][ny]<=visit[d.x][d.y])continue;

                if(map[nx][ny] ==1){
                    q.add(new Dot(nx,ny));
                    visit[nx][ny] = visit[d.x][d.y];
                }else{
                    q.add(new Dot(nx,ny));
                    visit[nx][ny] = visit[d.x][d.y]+1;
                }
            }
        }
    }
}
