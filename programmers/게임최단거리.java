import java.util.*;
class Solution {
    static class dot{
        int x,y;
        public dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static boolean[][] visit;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        Queue<dot> q = new LinkedList<>();
        q.add(new dot(0,0));
        visit[0][0] = true;
        while(!q.isEmpty()){
            dot d = q.poll();
            for(int i=0;i<4;i++){
                int nx = d.x+dx[i];
                int ny = d.y+dy[i];
                if(nx<0 ||ny <0||nx>=n||ny>=m) continue;
                if(maps[nx][ny] == 1 && !visit[nx][ny]){
                    maps[nx][ny]+=maps[d.x][d.y];
                    visit[nx][ny] = true;
                    q.add(new dot(nx,ny));
                }
            }
        }
        answer = maps[n-1][m-1] == 1?-1:maps[n-1][m-1];
        return answer;
    }
}