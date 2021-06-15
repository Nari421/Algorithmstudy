package boj;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cheeseCnt;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        int ans;
        for (ans = 0; isCheese(); ans++) {
            // 초기 세팅
            for (boolean[] arr : visited) {
                Arrays.fill(arr, false);
            }
            visited[0][0] = true;
            cheeseCnt = 0;

            DFS(0, 0);
        }

        bw.write(ans + "\n" + cheeseCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 판 위에 치즈가 존재하는가?
    public static boolean isCheese() {
        // map[i][j] = 2로 표시된 부분은 공기와 맞닿은 치즈이므로
        // 먼저 공기로 바꿔줘야 함.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }

        // 판 위에 치즈가 존재하는지 체크.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    // (0, 0)부터 시작해서 공기와 맞닿은 치즈를 찾음.
    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            // 범위를 벗어나는 경우
            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }

            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                if (map[dx][dy] == 1) {
                    map[dx][dy] = 2;
                    cheeseCnt++; // 다음에 지워질 치즈의 개수
                } else {
                    DFS(dx, dy);
                }
            }
        }
    }
//    static int n,m;
//    static int[][] map;
//    static boolean[][] visit;
//    static int time=0, pieces=0;
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static LinkedList<Dot> list ;
//    static class Dot{
//        int x;
//        int y;
//        public Dot(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new int[n][m];
//        visit = new boolean[n][m];
//        for(int i=0;i<n;i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0;j<m;j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//                visit[i][j] = false;
//            }
//        }
//        boolean zero = false;
//
//        //while(!zero){
//            for(int i=1;i<n;i++){
//                for(int j=1;j<m;j++){
//                    if(map[i][j] == 1 && visit[i][j] == false){
//                        pieces=1;
//                        list = new LinkedList<Dot>();
//                        dfs(i,j);
//                        //System.out.println(pieces);
//                        melt();
//                    }
//                }
//            }time++;
//            //System.out.println(pieces);
//        //}
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(map[i][j]+" ");
//            }System.out.println();
//        }
//    }
//
//    private static void melt() {
//        for(int i=0;i<list.size();i++) {
//            Dot d = list.get(i);
//            map[d.x][d.y] = 0;
//        }
//    }
//
//    private static void dfs(int x, int y) {
//        visit[x][y] = true;
//        int cnt=0;
//        for(int i=0;i<4;i++){
//            int nx = x+dx[i];
//            int ny = y+dy[i];
//            if(nx>0 && ny>0 && nx<n && ny<m){
//                if(visit[nx][ny] == false && map[nx][ny]==1){
//                    visit[nx][ny] = true;
//                    dfs(nx,ny);
//                    pieces++;
//                }
//            }
//            if(map[nx][ny] ==0)cnt++;
//            if(i==3 && cnt>0){
//                list.add(new Dot(x,y));
//                //System.out.println(x+" "+y);
//            }
//        }
//    }
}
