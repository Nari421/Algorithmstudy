package boj;

import java.util.Scanner;

public class sw1206 {
	static int flatsize=0,flat[];
	public static void main(String args[]) throws Exception { 
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			flatsize = sc.nextInt();
			flat = new int[flatsize];
			for(int i=0;i<flatsize;i++){
				flat[i] = sc.nextInt();
			}
			System.out.println("#"+test_case+" "+solve());
		}
	}
	private static int solve() {
		// TODO Auto-generated method stub
		int answer=0;
		for(int i=2;i<flatsize;i++){
			int flatmax = Integer.MIN_VALUE;
			for(int j=i-2;j<=i+2;j++){
				//System.out.println(flat[j]);
				if(j==i)continue;
				if(flat[j]<flat[i])flatmax = Math.max(flatmax, flat[j]);
				else{
					flatmax = -1;
					break;
				}
			}
			if(flatmax != -1){
				answer+=(flat[i]-flatmax);
			}
		}
		return answer;
	}

}
