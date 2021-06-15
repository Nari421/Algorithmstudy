package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13305 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[city-1];
        for(int i=0;i<city-1;i++){
            distance[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] oil = new long[city];
        for(int i=0;i<city;i++){
            oil[i] = Integer.valueOf(st.nextToken());
        }
        int now=0;
        int next=now+1;
        long answer=oil[0]*distance[0];
        while(next < city-1){
            if(oil[now] < oil[next]){
                answer += oil[now]*distance[next];
            }else{
                answer += oil[next]*distance[next];
                now = next;
            }
            next++;
        }
        System.out.println(answer);

    }
}
