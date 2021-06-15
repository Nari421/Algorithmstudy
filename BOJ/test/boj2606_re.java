package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2606_re {
    static int[][] map;
    static boolean[] visit;
    static int answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());
        map = new int[computer+1][computer+1];
        for(int[] i:map){
            for(int j:i){
                Arrays.fill(i,0);
            }
        }
        for(int i=0;i<connect;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }//연결 확인
        visit = new boolean[computer+1];
        bfs(1);
        System.out.println(answer);
    }

    private static void bfs(int index) {
        visit[index] = true;
        for(int i=1;i<visit.length-1;i++){
            if(visit[i]==false && map[index][i] == 1){
                answer++;
                bfs(i);
            }
        }
    }
}
