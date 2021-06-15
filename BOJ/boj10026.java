package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10026 {
    static int n=0;
    static char[][] map ;
    static boolean[][] visit ;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int color=0;
    static int colorWeak =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map= new char[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = input.charAt(j);
                visit[i][j] = false;
            }
        }
        //색약 아닌사람
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j] == false) {
                    switch (map[i][j]){
                        case 'R':
                        case 'G':
                        case 'B':
                            checkColor(i,j,map[i][j]);
                            color++;
                    }
                }
            }
        }
        for(boolean a[] : visit){
            Arrays.fill(a,false);
        }
        //R을 G
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 'R'){
                    map[i][j] = 'G';
                }
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false) {
                    switch (map[i][j]) {
                        case 'G':
                        case 'B':
                            checkColor(i, j, map[i][j]);
                            colorWeak++;
                    }
                }
            }
        }
        //색약인 사람
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(visit[i][j] == false) {
//                    switch (map[i][j]){
//                        case 'R':
//                        case 'G':
//                        case 'B':
//                            checkColor(i,j,map[i][j]);
//                            color++;
//                    }
//                }
//            }
//        }

        System.out.println(color);
        System.out.println(colorWeak);
    }

    private static void checkColor(int x, int y, char rgb) {
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(map[nx][ny]==rgb && visit[nx][ny] == false){
                    //System.out.println(nx+" , "+ny+" hi "+color);
                    //color++;
                    visit[nx][ny] = true;
                    checkColor(nx,ny,rgb);
                }
            }
        }
    }
}
