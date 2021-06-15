package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static int l =0;
    static int[][] chess;
    static boolean[][] visit;
    //static Queue<Dot> q = new LinkedList<Dot>();
    static int count=0;
    static class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Testcase = Integer.parseInt(br.readLine());
        int[] answer = new int[Testcase];
        for(int test=0;test< Testcase;test++){
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            visit = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start1 = Integer.parseInt(st.nextToken());
            int start2 = Integer.parseInt(st.nextToken());
            chess[start1][start2] = 0;
            visit[start1][start2] = true;
            st = new StringTokenizer(br.readLine());
            int end1 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());

            bfs(start1,start2,end1,end2);
            answer[test] = chess[end1][end2];
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
    public static void bfs(int x,int y,int end1,int end2){
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x,y));

        while(!q.isEmpty()){
            Dot d = q.poll();
            for(int i=0;i<8;i++){
                int nx = d.x+dx[i];
                int ny = d.y+dy[i];

                if(nx>=0 && ny>=0 && nx<l && ny<l){
                    if(visit[nx][ny] == false){
                        q.add(new Dot(nx,ny));
                        chess[nx][ny] = chess[d.x][d.y]+1;
                        visit[nx][ny] = true;
                        //System.out.println(nx +" , "+ny+ " : "+chess[nx][ny]);
                    }
                    if(nx == end1 && ny == end2){
                        return;
                    }
                }
            }
        }
    }
}
