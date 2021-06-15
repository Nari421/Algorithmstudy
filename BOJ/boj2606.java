package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2606 {
    static int answer=0;
    static boolean[][] computer;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        computer = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computer[x][y] = true;
            computer[y][x] = true;
        }
        Arrays.fill(visit,false);
        dfs(1);
        System.out.println(answer);
    }
    private static void dfs(int start){
        visit[start] = true;
        for(int i=1;i<=visit.length-1;i++){
            if(computer[start][i] == true&&visit[i]==false){
                answer++;
                dfs(i);
            }
        }
    }
}
