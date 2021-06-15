package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17135 {
    static int[] dx = {0, 0, 0};
    static int[] dy = {0, -1, 1};
    private static int n = 0, m = 0, d = 0, line = 0;
    private static int Max = -1;
    private static boolean[] Archer;
    private static int[][] castle;
    private static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        Archer = new boolean[m];
        castle = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(Max);

    }

    private static void combination(int index, int count) {
        if (count == 3) {
            depends();
            return;
        }
        for (int i = index; i < m; i++) {
            if (!Archer[i]) {
                Archer[i] = true;
                combination(i + 1, count + 1);
                Archer[i] = false;
            }
        }
    }

    private static void depends() {
        int[][] clone_castle = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(castle[i], 0, clone_castle[i], 0, castle[0].length);
        }
        for(boolean[] a : visit){
            for(boolean b:a){
                Arrays.fill(a,false);
            }
        }
        line = n;
        int answer = -1;
        for(int i=0;i<m;i++){
            if(Archer[i]==true){
                clone_castle = findE(clone_castle,i,line);
                System.out.println("archer : "+i);
            }
        }
        System.out.println(">>>>");
        for(int k=0;k<n;k++){
            for(int j=0;j<m;j++){
                System.out.print(clone_castle[k][j]);
            }System.out.println();
        }System.out.println("---------------------------");
    }

    private static int[][] findE(int[][] clone_castle, int archer, int lineA) {
        for(int i=0;i<3;i++){
            int nx = lineA-1+dx[i];
            int ny = archer+dy[i];

            if(nx<0 || nx>=n ||ny<0 || ny>=m)continue;
            if(Math.abs(lineA-1-nx)+Math.abs(i-ny)<=d){
                if(clone_castle[nx][ny]==1 && visit[nx][ny]==false){
                    System.out.println(nx+", "+ny);
                    clone_castle[nx][ny]=0;
                    visit[nx][ny] = true;
                    findE(clone_castle,archer,lineA-1);
                }
            }
            if(i==2){
                findE(clone_castle,archer,lineA-1);
            }
        }
        return clone_castle;
    }
}
