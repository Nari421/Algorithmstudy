import java.util.Scanner;

public class boj2156 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int p[] = new int[n+1];
        int dp[] = new int[n+1];

        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        dp[1] = p[1];
        if(n > 1)
            dp[2] = p[1] + p[2];
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+p[i],dp[i-3]+p[i-1]+p[i]));

        }

        System.out.println(dp[n]);
    }
}
