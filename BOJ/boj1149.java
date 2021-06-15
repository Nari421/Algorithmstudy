package boj;

import java.util.Scanner;



public class boj1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] list = new int[n][3];
        int[][] dp = new int[n][3];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = list[0][0];
        dp[0][1] = list[0][1];
        dp[0][2] = list[0][2];

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];

            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];

            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];

        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));

    }

}
