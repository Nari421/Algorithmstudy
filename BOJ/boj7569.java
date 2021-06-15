package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {
    static int n=0,m=0,h=0;
    static int[][][] tomato ;
    static boolean[][][] visit ;
    static Queue<Dot> red = new LinkedList<Dot>();
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int check=0;
    static class Dot {
        int x, y, z;

        public Dot(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[h][n][m];
        visit = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == -1) {
                        visit[i][j][k] = false;
                    }else if(tomato[i][j][k]==1){

                        visit[i][j][k] = false;
                        red.offer(new Dot(i,j,k));
                    }else visit[i][j][k] = true;
                }

            }
        }
        checkTomato();
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(tomato[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    check = Math.max(check,tomato[i][j][k]);
                }
            }
        }
        System.out.println(check-1);
    }
    static void checkTomato(){
        while(!red.isEmpty()){
            Dot dot = red.poll();
            for(int i=0;i<6;i++){
                int nx = dot.x+dx[i];
                int ny = dot.y+dy[i];
                int nz = dot.z+dz[i];
                if(0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m){
                    if(tomato[nx][ny][nz] == 0 && visit[nx][ny][nz]==true){
                        tomato[nx][ny][nz] = tomato[dot.x][dot.y][dot.z]+1;
                        visit[nx][ny][nz]=false;
                        red.offer(new Dot(nx,ny,nz));
                    }
                }
            }
        }
    }
}
