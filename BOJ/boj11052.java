package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11052 {
	static int n,card[],max = Integer.MIN_VALUE,dp[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n+1];
		dp = new int[n+1];
		visit = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++){
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i]=Math.max(dp[i], card[j]+dp[i-j]);
				System.out.print(dp[i]+" ");
			}System.out.println();
		}
		System.out.println(dp[n]);

	}
	private static void sumN(int start, int sum,int total) {
		if(sum == n){
//			for(int i=1;i<=n;i++){
//				if(visit[i]){
//					//tmp+=card[i];
//					System.out.println(i+" ");
//				}
//			}System.out.println("--------------------"+total);
			
			max = Math.max(max, total);
			return;
		}
		for(int i=start;i<=n;i++){
			if(!visit[i]){
				visit[i] = true;
				sumN(i,sum+i,total+card[i]);
				visit[i] = false;
			}
			if(visit[i] && n>sum){
				sumN(i,sum+i,total+card[i]);
			}
		}
		
	}

}
