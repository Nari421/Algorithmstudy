package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501_dp {
	static int n,dp[],t[],p[],answer=0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+2];
		t = new int[n+1];
		p = new int[n+1];
		t[0]=p[0]=0;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++){
			if(i+t[i]<=n+1){
				dp[i+t[i]] =  Math.max(dp[i+t[i]], dp[i]+p[i]);
				System.out.println(i);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]); 
			for(int j:dp){
				System.out.print(" "+j+" ");
				
			}System.out.println();
		}
		System.out.println(dp[n+1]);
	}

}
