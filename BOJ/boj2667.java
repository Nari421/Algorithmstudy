package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj2667 {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;
    static int areasize=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visit = new boolean[n][n];
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;
        String input="";
        for(int i=0;i<n;i++){
            input = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = input.charAt(j)-'0';
                if(map[i][j] == 0){
                    visit[i][j]=false;
                }else {
                    visit[i][j] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1 && visit[i][j]==true){
                    areasize=0;
                    countArea(i,j);
                    cnt++;
                    if(areasize == 0)areasize=1;
                    ans.add(areasize);
                }
            }
        }

        System.out.println(cnt);
        ans.sort(null);
        for(int i : ans){
            System.out.println(i);
        }

    }

    private static void countArea(int x, int y) {
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(map[nx][ny]!=0&&visit[nx][ny]==true ){
                    areasize++;
                    visit[nx][ny]=false;
                    countArea(nx,ny);
                }
            }
        }
    }
}

