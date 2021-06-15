package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//{0,1,2}
//0: 없음 1:뱀 2:사과
public class boj3190 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    static int n =0,k=0,l=0,answer=0;
    static int[][] map ;
    static char[] dir ;
    static int[] time;
    static Queue<Dot> q = new LinkedList<Dot>();
    static class Dot{
        int x,y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int[] a : map){
            for(int v:a){
                Arrays.fill(a,0);
            }
        }
        map[1][1] =1;
        k= Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
        }
        l = Integer.parseInt(br.readLine());
        time = new int[l];
        dir = new char[l];
        for(int i=0;i<l;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char y = st.nextToken().charAt(0);
            time[i] = x;
            dir[i] = y;
        }
        q.add(new Dot(1,1));
        moveSnake();
        System.out.println(answer);

    }

    private static void moveSnake() {
        int i=0,d=1,col =1,row=1;
        while(true){
            if(i<l && answer==time[i]){
                if(dir[i] == 'D'){
                   d =  (d+1)%4;

                }else{
                    d = (d+3)%4;
                }
                i++;
            }
            int nx = row+dx[d];
            int ny = col+dy[d];
            q.add(new Dot(nx,ny));
            if(nx<=0 || nx>n || ny<=0 || ny>n){
                answer++;
                break;
            }
            if(map[nx][ny] == 2){
                map[nx][ny] = 1;
            }else if(map[nx][ny]==1){
                answer++;
                break;
            }else if(map[nx][ny] == 0){
                map[nx][ny] = 1;
                Dot dot = q.poll();
                map[dot.x][dot.y] =0;
            }
            row = nx;
            col = ny;
            answer++;
        }
    }

}
