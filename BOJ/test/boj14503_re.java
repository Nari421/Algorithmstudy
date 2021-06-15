package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503_re {
    static int[][] area;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanrobot(r, c, d);
        System.out.println(answer);
    }

    private static void cleanrobot(int r, int c, int d) {
        if(area[r][c] == 1)return;
        else if(area[r][c]==0){
            area[r][c]=-1;
            answer++;
        }
        int nd = d;
        for(int i=0;i<4;i++){
            nd = (nd+3)%4;
            int nr = r+dr[nd];
            int nc = c+dc[nd];
            if(area[nr][nc]==0){
                cleanrobot(nr,nc,nd);
                return;
            }
        }
        cleanrobot(r-dr[d],c-dc[d],d);
        return;

    }
}
