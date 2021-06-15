package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15683_other {
	static int N, M, res, ccCnt;
    static CCTV[] cctvs;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 방향
    static int[][][] ccDir = { // 각 cctv가 볼 수 있는 영역(회전)
            {{0}},
            {{1}, {2}, {3}, {0}}, // 1번 cctv
            {{1, 3}, {0, 2}}, // 2번 cctv
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv
            {{0, 1, 2, 3}}, // 5번 cctv
    };
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        int[][] map = new int[N][M];
        cctvs = new CCTV[8];
        
        int remain = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // CCTV일 경우
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs[ccCnt++] = new CCTV(map[i][j], i, j);                
                } 
                // 벽일경우
                else if(map[i][j] == 6) remain--;
            }
        }
        
        res = Integer.MAX_VALUE;
        process(0, remain - ccCnt, map);
        
        System.out.println(res);
    }
 
    private static void process(int idx, int remain, int[][] map) {
        
        // 모든 CCTV의 감시 영역을 확인했다면
        if(idx == ccCnt) {
            // 사각 지대의 최소 크기 갱신
            res = Math.min(res, remain);
 
            return;
        }
        
        int[][] newMap = new int[N][M];
        copy(newMap, map);
        
        // 각 CCTV를 확인
        CCTV cc = cctvs[idx];
        
        // 해당 CCTV가 90도씩 회전하며 감시
        for (int j = 0; j < ccDir[cc.type].length; j++) {
            // 해당 CCTV가 감시할 수 있는 방향으로 감시
            int check = 0;
            // 현재 상태에서 감시할 수 있는 방향
            for (int k = 0; k < ccDir[cc.type][j].length; k++) {
                int d = ccDir[cc.type][j][k];
                check += observation(cc.r, cc.c, d, newMap);
            }
            
            process(idx + 1, remain - check, newMap);
            // 다른 방향으로도 확인해보기 위해 map 상태를 되돌리자.
            copy(newMap, map);
        }
        
    }
    
    private static int observation(int r, int c, int d, int[][] map) {
        
        // 감시할 수 있는 영역의 수
        int cnt = 0;
        
        while(true) {
            
            r += dr[d];
            c += dc[d];
            
            // 범위를 벗어나거나 벽이 있다면
            if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6) return cnt;
            // 다른 CCTV가 있거나 이미 감시된 영역일 경우 pass
            if((map[r][c] >= 1 && map[r][c] <= 5) || map[r][c] == -1) continue;
            // 빈 칸일 경우
            map[r][c] = -1;
            cnt++;
        }
        
    }
 
    private static void copy(int[][] newMap, int[][] map) {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        
    }
 
    static class CCTV {
        int type, r, c;
 
        public CCTV(int type, int r, int c) {
            this.type = type;
            this.r = r;
            this.c = c;
        }
        
    }
 
}