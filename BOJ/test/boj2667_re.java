package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class boj2667_re {
    static int[][] apart;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count=0,n=0,size=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        apart =new int[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<n;j++){
                apart[i][j] = s.charAt(j)-48;
                visit[i][j] = false;
            }
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(apart[i][j] ==1 && visit[i][j]==false){
                    visit[i][j] = true;
                    list.add(dfs(i,j));
                    count++;
                    size=0;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }
    }
    public static int dfs(int x, int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny))continue;
            if(visit[nx][ny] == false && apart[nx][ny] == 1){
                size++;
                visit[nx][ny] = true;
                dfs(nx,ny);
            }
        }
        return size+1;
    }
    public static boolean isRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}
