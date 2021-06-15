package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {
	static int n,map[],cnt=0,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
	static int flag[];
	static char op[];
	static boolean use[];
	//0 :+ 1:- 2:* 3:/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		flag = new int[4];
		op = new char[n-1];
		use = new boolean[n-1];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			map[i] = Integer.parseInt(s.nextToken());
		}
		s = new StringTokenizer(br.readLine());
		int index=0;
		for(int i=0;i<4;i++){
			flag[i]= Integer.parseInt(s.nextToken());
			for(int j=0;j<flag[i];j++){
				char tmp;
				if(i==0){
					tmp='+';
				}else if(i==1){
					tmp='-';
				}else if(i==2){
					tmp='*';
				}else {
					tmp='/';
				}
				op[index++]=tmp;
			}
		}
		combination(1,map[0]);
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void combination(int start,int sum) {
		// TODO Auto-generated method stub
		if(start==n){
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		for(int i=0;i<n-1;i++){
			if(use[i] == false){
				use[i] = true;
				switch(op[i]){
				case '+':
					combination(start+1,  sum+map[start]);
					break;
				case '-':
					combination(start+1,  sum-map[start]);
					break;
				case '*':
					combination(start+1,  sum*map[start]);
					break;
				case '/':
					Math.abs(sum);
					combination(start+1,  sum/map[start]);
					break;
				}
				use[i] = false;
			}

			
		}
		
	}

}
