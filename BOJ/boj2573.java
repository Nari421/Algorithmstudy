package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2573 {
    static int N,M;
    static int[][] ice,reice;
    static boolean[][] visit;
    static LinkedList<Dot> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];
        reice = new int[N][M];
        visit = new boolean[N][M];
        list = new LinkedList<Dot>();
        int separation=0,year=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                ice[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
                if(ice[i][j] != 0){
                    list.add(new Dot(i,j));
                }
            }
        }
        while(separation<2) {
            for(int i=0;i<list.size();i++){
                Dot d = list.get(i);
                if(visit[d.x][d.y]==false){
                    dfs(d.x,d.y);
                    separation++;
                }
            }
            if(separation>=2){
                System.out.println(year);
                break;
            }
            if(list.size() == 0){
                System.out.println(0);
                break;
            }
            reduceArea();

            System.out.println();
            ice = reice.clone();
            reice = new int[N][M];

            checklist();
            separation=0;
            year++;
        }

    }

    private static void checklist() {
        list.clear();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ice[i][j]!=0){
                    list.add(new Dot(i,j));
                }
            }
        }
        for(boolean a[]:visit){
            Arrays.fill(a,false);
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
            if(ice[nx][ny] !=0 && visit[nx][ny]==false){
                visit[nx][ny]=true;
                dfs(nx,ny);
            }
        }
    }

    private static void reduceArea() {
        int zero=0;
        for(int index=0;index<list.size();index++){
            zero=0;
            Dot d = list.get(index);
            for(int i=0;i<4;i++){
                int nx = d.x+dx[i];
                int ny = d.y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
                if(ice[nx][ny]==0)zero++;
            }
            reice[d.x][d.y] = ice[d.x][d.y]-zero;
            if(reice[d.x][d.y]<=0) {
                reice[d.x][d.y]=0;
            }
        }
    }
}
