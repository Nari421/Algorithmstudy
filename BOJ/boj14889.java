package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14889 {
    static int n=0;
    static int[][] players;
    static boolean[] visit;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        players = new int[n][n];
        visit = new boolean[n];
        for(int i=0;i<n;i++){ //input
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(Min);
    }

    private static void combi(int idx, int count) {
        if(count == n/2){
            diff();
            return;
        }
        for(int i = idx ; i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                combi(i+1,count+1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start =0 ;
        int team_link = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(visit[i] == true && visit[j] == true){
                    team_start +=players[i][j];
                    team_start +=players[j][i];
                }else if(visit[i] == false && visit[j] == false){
                    team_link +=players[i][j];
                    team_link +=players[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }
}
