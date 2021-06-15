package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {
    static int[][] map ;
    static int[] visit;
    static int N,p2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        int relationship = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new int[N+1];

        for(int i=0;i<relationship;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        Arrays.fill(visit,0);
        bfs(p1);
    }
    static void bfs(int p1){
        Queue<Integer> q = new LinkedList<>();
        q.offer(p1);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int k = 1; k <= N; k++) {
                if (map[temp][k] == 1 && visit[k] == 0) {
                    q.offer(k);
                    visit[k] = visit[temp]+1;
                }
            }
        }
        System.out.println(visit[p2] == 0 ? -1 : visit[p2]);
    }
}
