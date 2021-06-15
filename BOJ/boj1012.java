package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] area;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0;test<T;test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            area = new int[N][M];
            int harvesting = 0;
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x =Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());
                area[y][x] = 1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(area[i][j] == 1){
                        dfs(i,j);
                        ++harvesting;
                    }
                }
            }
            System.out.println(harvesting);
        }
    }
    public static void dfs(int x,int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(ny<0 || nx<0 || nx>=N || ny>=M){
                continue;
            }
            if(area[nx][ny] == 0) continue;

            area[nx][ny] =0;
            dfs(nx,ny);
        }
    }
}
