package boj;

import java.util.Scanner;

public class sw1952 {
//	static int moneys[] = new int[4];
//	static int swim[] = new int[12];
//	static int max = Integer.MAX_VALUE;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//		for(int test_case = 1; test_case <= T; test_case++){
//			for(int i=0;i<4;i++){
//				moneys[i] = sc.nextInt();
//			}
//			for(int i=0;i<12;i++){
//				swim[i] = sc.nextInt();
//			}
//			System.out.println("#"+test_case+" "+payment(0,0));
//		}
//
//	}
//	private static int payment(int index, int sum) {
//		if(index>=12)return sum;
//		int ret = max;
//		ret = Math.min(ret, payment(index+1,sum+moneys[0]*swim[index]));
//		ret = Math.min(ret, payment(index+1,sum+moneys[1]));
//		ret = Math.min(ret, payment(index+1,sum+moneys[2]));
//		ret = Math.min(ret, payment(index+12,moneys[3]));
//		return ret;
//	}
	static int day, month, month3, year; 
	static int[] use_plan = new int[12]; 
	static int[] min_sum = new int[12]; // size will be 12, initialized at each loop 
	static int test_num; // dynamically store and calculate minimum sum public static 
	static int dynamic_count(int[] min_sum) { 
		min_sum[0] = Math.min(use_plan[0] * day, month); // make 3-month size minimum 
		for (int i = 1; i < 3; i++) { 
			if (use_plan[i] == 0) { min_sum[i] = min_sum[i-1]; } 
			else { min_sum[i] = min_sum[i-1] + Math.min(use_plan[i] * day, month); } } 
		if (min_sum[2] > month3) min_sum[2] = month3; // iterate over use_plan, compute the min_sum 
		for (int i = 3; i < 12; i++) { 
			if (use_plan[i] == 0) { 
				min_sum[i] = min_sum[i-1]; } 
			else {
				min_sum[i] = Math.min(min_sum[i-1]+Math.min(use_plan[i] * day, month), min_sum[i-3] + month3); 
				} 
			} 
		return Math.min(min_sum[11], year); 
		} 
	public static void main(String args[]) throws Exception { /* 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 
	여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 
	따라서*/
		int[] out_result = new int[12]; 
		Scanner sc = new Scanner(System.in); 
		int test_num; test_num=sc.nextInt(); /* 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다. */ 
		for(int test_case = 0; test_case < test_num; test_case++) { 
			day = sc.nextInt(); 
			month = sc.nextInt(); 
			month3 = sc.nextInt(); 
			year = sc.nextInt(); 
			for (int j = 0; j < 12; j++) {
				use_plan[j] = sc.nextInt();
				} 
			out_result[test_case] = dynamic_count(min_sum); 
			} 
		for (int i = 0; i < test_num; i++) { 
			System.out.println("#" + (i+1) + " " + out_result[i]); 
			} sc.close(); 
		}
	}
