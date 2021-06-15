package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576_re {
    static int n,m,answer=0;
    static int[][] tomato;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static class position{
        int x,y;
        public position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<position> list =new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tomato = new int[m][n];
        visit = new boolean[m][n];
        for(int i=0;i<m;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    list.add(new position(i,j));
                    visit[i][j] = true;
                }
            }
        }
        dfs();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(tomato[i][j]+" ");
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer,tomato[i][j]);
            }System.out.println();
        }
        System.out.println(answer-1);

    }

    private static void dfs() {
        while(!list.isEmpty()){
            position p=list.poll();
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx<0 || ny<0 || nx>=m||ny>=n)continue;
                if(visit[nx][ny] == false && tomato[nx][ny]==0){
                    tomato[nx][ny] = tomato[p.x][p.y]+1;
                    visit[nx][ny] = true;
                    list.add(new position(nx,ny));
                }
            }
        }

    }
}
