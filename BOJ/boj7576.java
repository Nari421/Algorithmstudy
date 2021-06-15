package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    static int n=0,m=0;
    static int[][] tomato ;
    static boolean[][] visit ;
    static Queue<Dot> red = new LinkedList<Dot>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int check=0;
    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tomato = new int[m][n];
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == -1) {
                    visit[i][j] = false;
                }else if(tomato[i][j]==1){
                    visit[i][j] = false;
                    red.offer(new Dot(i,j));
                }else visit[i][j] = true;
            }
        }
        checkTomato();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(tomato[i][j]+" ");
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                check = Math.max(check,tomato[i][j]);
            }System.out.println();
        }
        System.out.println(check-1);
    }
    static void checkTomato(){
        while(!red.isEmpty()){
            Dot dot = red.poll();
            for(int i=0;i<4;i++){
                int nx = dot.x+dx[i];
                int ny = dot.y+dy[i];
                if(0<=nx && nx<m && 0<=ny && ny<n){
                    if(tomato[nx][ny] == 0 && visit[nx][ny]==true){
                        tomato[nx][ny] = tomato[dot.x][dot.y]+1;
                        visit[nx][ny]=false;
                        red.offer(new Dot(nx,ny));
                    }
                }
            }
        }


    }
}
