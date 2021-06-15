package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17281 {
    static int N;
    static int[][] line;
    static boolean[] visit;
    static int[] player;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N][10];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<10;j++){
                line[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[10];
        player = new int[10];
        player[4] = 1;
        max = -1;
        perm(1);
        System.out.println(max);
    }
    public static void perm(int len) { // 선수 배치하기
        if (len == 4) { // 4번째 타자는 1번.
            perm(len + 1);
            return;
        }
        if (len == 10) {
            // 선택완료
            int score = playGame();
            max = max<score? score:max;
            return;
        }

        for (int i = 2; i < 10; i++) {
            if (visit[i])
                continue;
            player[len] = i;
            visit[i] = true;
            perm(len + 1);
            visit[i] = false;
        }
    }

    public static int playGame() {
        int score = 0;
        int out;
        boolean[] roo = new boolean[4];
        int hitter = 1;

        for (int inning = 0; inning < N; inning++) {
            out = 0;
            Arrays.fill(roo, false);
            while(true) {
                int now = line[inning][player[hitter]];
                if(hitter==9) hitter = 1;
                else hitter++;
                if (now == 1) { // 안타
                    if(roo[3]) {
                        score++;
                        roo[3]=false;
                    }
                    for(int r=2;r>=1;r--) {
                        if(roo[r]) {
                            roo[r]=false;
                            roo[r+1]=true;
                        }
                    }
                    roo[1]=true;
                } else if (now == 2) {
                    if(roo[3]) {
                        score++;
                        roo[3]=false;
                    }
                    if(roo[2]) {
                        score++;
                        roo[2]=false;
                    }
                    if(roo[1]) {
                        roo[1]=false;
                        roo[3]=true;
                    }
                    roo[2]=true;

                } else if (now == 3) {
                    for(int r=1;r<=3;r++) {
                        if(roo[r]) {
                            score++;
                            roo[r]=false;
                        }
                    }
                    roo[3] = true;
                } else if (now == 4) {
                    for(int r=1;r<=3;r++) {
                        if(roo[r]) {
                            score++;
                            roo[r]=false;
                        }
                    }
                    score++;
                } else if (now == 0) {
                    out++;
                    if (out == 3) {
                        break;
                    }
                }
            }
        }
        return score;
    }

}
