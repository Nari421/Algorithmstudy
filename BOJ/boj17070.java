package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17070 {
    static int[][] map;
    static boolean[][] visit;
    static int N;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        map =new int[N+1][N+1];
//        visit = new int[N+1][N+1];
//        for(int i=0;i<N;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j=0;j<N;j++){
//                map[i+1][j+1] = Integer.parseInt(st.nextToken());
//                visit[i+1][j+1] = 0;
//            }
//        }
//        bfs();
//        System.out.println(visit[N][N]);
//    }
//    static class Dot{
//        int x1,x2;
//        int y1,y2;
//        public Dot(int x1, int y1,int x2,int y2){
//            this.x1 = x1;
//            this.y1 = y1;
//            this.x2 = x2;
//            this.y2 = y2;
//        }
//        public int direction(){
//            if(x1-x2 == 0 && y1-y2<0){
//                return 1;
//            }else if(x1-x2<0 && y1-y2==0){
//                return 2;
//            }
//            return 3;
//        }
//    }
//    private static void bfs() {
//        Queue<Dot> q = new LinkedList<>();
//        q.add(new Dot(1,1,1,2));
//        visit[1][2] = 1;
//
//        while(!q.isEmpty()){
//            Dot d = q.poll();
//            int direct = d.direction();
//            System.out.println("direct : "+direct);
//            int[] xy = new int[2];
//            if(d.x2 == N && d.y2 == N){
//                visit[d.x2][d.y2]+=1;
//                break;
//            }
//            if(direct ==1){
//                for(int i=0;i<2;i++){
//                    xy = check(i,d.x2,d.y2);
//                    q.add(new Dot(d.x2, d.y2, xy[0], xy[1]));
//                    visit[xy[0]][xy[1]] = 1;
//                    System.out.println("q peek() : "+q.peek());
//                }
//            }else if(direct == 2){
//                for(int i=0;i<2;i++){
//                    if(i==0){
//                        xy = check(2,d.x2,d.y2);
//                        q.add(new Dot(d.x2, d.y2, xy[0], xy[1]));
//                        visit[xy[0]][xy[1]] = 1;
//                    }else{
//                        xy = check(i,d.x2,d.y2);
//                        q.add(new Dot(d.x2, d.y2, xy[0], xy[1]));
//                        visit[xy[0]][xy[1]] = 1;
//                    }
//                }
//            }else{
//                for(int i=0;i<3;i++){
//                    xy = check(i,d.x2,d.y2);
//                    q.add(new Dot(d.x2, d.y2, xy[0], xy[1]));
//                    visit[xy[0]][xy[1]] = 1;
//                }
//            }
//        }
//    }
//    static int[] check(int index,int x2,int y2){
//        int[] xy = new int[2];
//        if(index==0){
//            if(x2 <=N && y2+1<=N){
//                 xy[0]= x2;
//                 xy[1] = y2+1;
//            }
//        }else if(index==2){
//            if(x2+1 <=N && y2<=N){
//                xy[0]= x2+1;
//                xy[1] = y2;
//            }
//        }else if(index==1){
//            if(x2+1 <=N && y2+1<=N){
//                xy[0]= x2+1;
//                xy[1] = y2+1;
//            }
//        }
//        return xy;
//    }
//}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        dfs(0,1,1);

        System.out.println(cnt);

    } // end of main
    static int cnt;
    static int[] dy = {1,0, 1};
    static int[] dx = {0,1, 1}; //아래 오른쪽 대각선
    public static void dfs(int y,int x, int type){
        //type
        //0 : 세로
        //1 : 가로
        //2 : 대각선

        //visit[y][x]=true;
        System.out.println(y+","+x);
        if(y==N-1 && x==N-1) { //도착
            System.out.println("도착");
            cnt++;
            return;
        }

        int[] Dir = getDir(type);

        for(int i=0;i<Dir.length;i++) {

            int ny = y+dy[Dir[i]];
            int nx = x+dx[Dir[i]];

            if(ny<0 || ny>N-1 || nx<0 || nx>N-1 || map[ny][nx]!=0) continue;
            //대각선으로 이동시 주변 4칸이 확보되어 있어야 한다.
            if(Dir[i]==2 && (map[y][x+1]!=0||map[y+1][x]!=0)) continue;


            dfs(ny,nx,Dir[i]);

        }

    }

    public static int[] getDir(int type) {

        //type
        //0 : 세로
        //1 : 가로
        //2 : 대각선

        //아래 오른쪽 대각선
        if(type == 0) { //세로
            int[] ret = {0,2};
            return ret;
        }
        if(type == 1) { //가로
            int[] ret = {1,2};
            return ret;
        }
        if(type ==2) {
            int[] ret = {0,1,2};
            return ret;
        }
        return null;
    }

}