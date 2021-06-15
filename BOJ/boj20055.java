package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20055 {
	static int n,k,belt[],answer=0,robot[];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		belt = new int[n*2];
		robot = new int[n];
		for(int i=0;i<n*2;i++){
			belt[i] = Integer.parseInt(st.nextToken());
		}
		moveRobot(0);
		System.out.println(answer);
	}
	private static void moveRobot(int index) {
		while(true){
			//1번 회전
			int tmp = belt[2*n-1];
			for(int i=(2*n -1);i>0;i--){
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;
			//로봇 회전
			for (int i = n - 1; i >= 1; i--) {
				robot[i] = robot[i - 1];
				if(i-1 == 0 && robot[i]==1){
					robot[i-1]=0;
				}
			}
			if(robot[n-1] == 1){
				robot[n-1]=0;
			}//끝 로봇
			//2번 한칸이동
			for(int i=n-1;i>0;i--){
				if(belt[i]>0 && robot[i] == 0 && robot[i-1]==1){
					robot[i]=1;
					robot[i-1] = 0;
					belt[i]--;
				}
			}
			if(robot[n-1]==1){
				robot[n-1]=0;
			}			
			//3번 올리기
			if(robot[0] ==0 && belt[0]>0){
				robot[0] =1;
				belt[0]--;
			}
			
			answer++;
			int cnt=0;
			for(int i:belt){
				if( i ==0)cnt++;
			}
			if(cnt>=k){
				break;
			}
		}
		
	}

}
