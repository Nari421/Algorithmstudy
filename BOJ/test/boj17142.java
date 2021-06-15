package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17142 {
    static int n,m,answer=Integer.MAX_VALUE;
    static int map[][],copyed[][];
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class virus{
        int x, y,v;
        public virus(int x, int y,int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    static LinkedList<virus> viruslist = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        copyed = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruslist.offer(new virus(i, j,0));
                    visit[i][j] = true;
                    map[i][j] =-1;
                }else if(map[i][j] == 1){
                    map[i][j] = -99;
                }
            }
        }
        setVirus(0,0);
        System.out.println(answer==Integer.MAX_VALUE?-1:answer);
    }

    private static void setVirus(int start,int cnt) {
        if(cnt == m){
            Queue<virus> newvirus =  copymap();
            spreadvirus(newvirus);
            int tmp = checkvirus();
            if(tmp==-1){
                tmp = Integer.MAX_VALUE;
                answer = Math.min(answer,tmp);
            }else{
                answer = Math.min(answer,tmp);
            }
            return;
        }
        for(int i=start;i<viruslist.size();i++){
            int x = viruslist.get(i).x;
            int y = viruslist.get(i).y;
            if(map[x][y]==-1){
                map[x][y] = -1000;
                setVirus(i,cnt+1);
                map[x][y]=-1;
            }
        }

    }

    private static int checkvirus() {
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(copyed[i][j] == 0 && visit[i][j]==false)return -1;
                if(copyed[i][j]== -99)continue;
                max = Math.max(max,copyed[i][j]);
            }
        }
        return max;
    }

    private static void spreadvirus(Queue<virus> q) {
        System.out.println("--------------------------");
        for(virus v : q){
            System.out.println("-->"+v.x+" , "+v.y);
        }
        while(!q.isEmpty()){
            virus v = q.poll();
            for(int i=0;i<4;i++){
                int nx = v.x+dx[i];
                int ny = v.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=n)continue;
                if(copyed[nx][ny] == -99)continue;
                if(copyed[nx][ny]==0 && visit[nx][ny] == false){
                    copyed[nx][ny] = v.v+1;
                    q.add(new virus(nx,ny,copyed[nx][ny]));
                }
                if(copyed[nx][ny] == -1 && visit[nx][ny]==true){
                    q.add(new virus(nx,ny,v.v+1));
                    visit[nx][ny] =false;
                    //continue;
                    //copyed[nx][ny] = copyed[v.x][v.y]+1;
                    //q.add(new virus(nx+dx[i],ny+dy[i]));
                }
            }

        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(copyed[i][j] == -99){
                    System.out.print(" | ");
                }else{
                    System.out.print(" "+copyed[i][j] + " ");
                }

            }
            System.out.println();
        }
//        System.out.println("======================");
//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < n; j++) {
//
//                    System.out.print(visit[i][j]+" ");
//
//            }
//            System.out.println();
//        }

    }

    private static Queue<virus> copymap() {
        Queue<virus> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == -1000){
                    list.add(new virus(i,j,0));
                    copyed[i][j] = 0;
                    visit[i][j] = true;
                }else if(map[i][j] == -1){
                    copyed[i][j] = map[i][j];
                    visit[i][j] = true;
                }else{
                    copyed[i][j] = map[i][j];
                    visit[i][j] = false;
                }

            }
        }
        return list;
    }
}
