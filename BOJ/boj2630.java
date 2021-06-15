package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
    static int[][] map;
    static int zero, one;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] answer = makepaper(arr);
        for(int i : answer){
            System.out.println(i);
        }
    }
    static int[] makepaper(int[][] arr) {
        int[] answer = {};
        int n=arr.length;
        map=arr;
        zero=0;
        one=0;
        check(0, 0, n);

        answer=new int[2];
        answer[0]=zero;
        answer[1]=one;

        return answer;
    }

    static void check(int x, int y, int k){
        if(isPossible(x, y, k)){
            int val=map[x][y];
            if(val==1) one++;
            else zero++;
            return;
        }
        int half=k/2;
        check(x, y, half);
        check(x, y+half, half);
        check(x+half, y, half);
        check(x+half, y+half, half);
    }

    static boolean isPossible(int x, int y, int k){
        int val=map[x][y];
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                if(map[i][j]!=val) return false;
            }
        }
        return true;
    }
}
