package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetingTime = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetingTime[i][0] = Integer.valueOf(st.nextToken());
            meetingTime[i][1] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(meetingTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1])
                    return a[0]-b[0];
                else
                    return a[1]-b[1];
            }
        });
        int answer=0;
        int time=-1;
        for(int i=0;i<N;i++){
            if(meetingTime[i][0] >= time){
                time = meetingTime[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
