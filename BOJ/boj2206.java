package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N=0,M=0;
    static boolean[][][] visit;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }
        bfs();
        if(ans==0){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(0, 0, 1, 0));

        while (!q.isEmpty()) {

            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int cnt = node.cnt;
            int jump = node.jump;

            if (row == N - 1 && col == M - 1) {
                ans = Math.min(ans, cnt);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if (isBoundary(nr, nc)) {
                    if (jump == 1) {

                        if (!visit[jump][nr][nc] && map[nr][nc] == 0) {
                            visit[jump][nr][nc] = true;
                            q.offer(new Node(nr, nc, cnt + 1, jump));
                        }

                    } else {

                        if (map[nr][nc] == 1) {
                            if (!visit[jump + 1][nr][nc]) {
                                visit[jump + 1][nr][nc] = true;
                                q.offer(new Node(nr, nc, cnt + 1, jump + 1));
                            }
                        } else if (map[nr][nc] == 0) {
                            if (!visit[jump][nr][nc]) {
                                visit[jump][nr][nc] = true;
                                q.offer(new Node(nr, nc, cnt + 1, jump));
                            }
                        }
                    }
                }
            }
        }
    }
    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < N) && (col >= 0 && col < M);
    }
    static class Node {
        int row;
        int col;
        int cnt;
        int jump;
        public Node(int row, int col, int cnt, int jump) {
            super();
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.jump = jump;
        }
    }
}
