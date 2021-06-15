package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int d[] = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && d[i] <= d[j]) {
                    d[i] = d[j] + 1;
                } else if (arr[i] == arr[j]) {
                    d[i] = d[j];
                }
            }
        }
        int max = 0;
        for (int i : d) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
