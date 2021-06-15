package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*안전 영역
* 5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
*
* 5
* */
public class boj2468 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max=0,cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visit = new boolean[n][n];
        list.add(0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
                if(!list.contains(map[i][j])){
                    list.add(map[i][j]);
                }
            }
        }
        int index=0;
        while(index<list.size()){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]>list.get(index) && visit[i][j]==false){
                        visit[i][j]=true;
                        checkarea(i,j,list.get(index));
                        cnt++;
                    }
                }
            }
            max = Math.max(max,cnt);
            index++;
            cnt=0;
            for(boolean a[] : visit){
                Arrays.fill(a,false);
            }
        }
        System.out.println(max);
    }

    private static void checkarea(int x, int y, int index) {
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(map[nx][ny]>index && visit[nx][ny]==false){
                    visit[nx][ny] = true;
                    checkarea(nx,ny,index);
                }
            }
        }
    }
}
