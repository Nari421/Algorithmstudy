package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502_re {
    static int n,m,answer=0;
    static int map[][],copyed[][];
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class virus{
        int x, y;
        public virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<virus> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyed = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.offer(new virus(i,j));
                    visit[i][j] = true;
                }
            }
        }

        setWall(0,0);
        System.out.println(answer);
    }

    private static void setWall(int start,int cnt) {//조합 찾기
        if(cnt == 3){
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, copyed[i], 0, map[0].length);
            }
            for(virus v : q){
                setVirus(v.x,v.y);
            }
            answer = Math.max(answer,countVirus());
            return;
        }
        for(int i=start;i<n*m;i++){
            int x = i/m;
            int y = i%m;
            if(map[x][y] == 0){
                map[x][y] = 1;
                setWall(i,cnt+1);
                map[x][y] = 0;
            }
        }

    }

    private static int countVirus() {
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyed[i][j]==0)count++;
            }
        }
        return count;
    }

    private static void setVirus(int x, int y) {
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0||nx>=n||ny>=m)continue;
            if(copyed[nx][ny]==0){
                copyed[nx][ny] =2;
                setVirus(nx,ny);
            }
        }
    }
}
