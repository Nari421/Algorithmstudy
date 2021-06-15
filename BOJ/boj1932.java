import java.util.*;

public class b1932 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max= 0, n = scan.nextInt();
        int[][] dp = new int[n][n];

        dp[0][0] = scan.nextInt();
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = scan.nextInt();
                System.out.println(i+" / "+j);
                if(j == 0){
                    dp[i][j] += dp[i-1][j];
                    System.out.println(dp[i][j]);}
                else if(j == i){
                    dp[i][j] += dp[i-1][j-1];
                    System.out.println("두번째"+dp[i][j]);
                }
                else{
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                    System.out.println("세번째"+dp[i][j]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);

    }
}
