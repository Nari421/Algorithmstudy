package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];
        for(int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        int left = 1, right = houses[n-1] - houses[0], mid = 0;
        while(left <= right) {
            int cnt = 1, pre = houses[0];
            mid = (left + right) / 2;
            for(int house : houses) {
                if(house - pre >= mid) {
                    cnt++; pre = house;
                }
            }
            if(cnt >= c) left = mid + 1;
            else right = mid - 1;
        }
        System.out.print(right);
    }
}