package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class sw1952_re {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int moneys[][] = new int[4][13];
			int swim[] = new int[13];
			int min=0;
			
			for(int i=0;i<4;i++){
				moneys[i][0] = sc.nextInt();
				for(int j=1;j<13;j++){
					moneys[i][j] = -1;
				}
			}
			
			for(int i=1;i<=12;i++){
				swim[i] = sc.nextInt();
				moneys[0][i] = moneys[0][0]*swim[i];
			}
			min = totalpay(moneys[0]);
			System.out.println(payment(moneys,swim,min));
		}
	}

	private static int totalpay(int[] money) {
		int answer=0;
		for(int i=1;i<=12;i++){
			if(money[i]==-1)continue;
			answer+=money[i];
		}
		return answer;
	}

	private static int payment(int[][] moneys, int[] swim,int min) {
		int tmp=Integer.MAX_VALUE;
		for(int i=1;i<3;i++){
			for(int j=1;j<=12;j++){
				if(swim[j] == 0)continue;
				if(i==1){
					moneys[i][j]=moneys[i][0];
					if(moneys[i][j]>moneys[i-1][j]){
						moneys[i][j]=moneys[i-1][j];
					}
				}else if(i==2){
					if(isRange(j,swim,moneys[i])){
						int sum = calcmonth(moneys[i-1],j);
						if(moneys[1][0]>moneys[2][0] && tmp<sum){
							moneys[i][j-1]=moneys[i-1][j-1];
						}						
						moneys[i][j] = moneys[i][0];
						if(moneys[i][j]<sum){
							for(int k=1;k<=2;k++){
								moneys[i][j+k]=0;
							}
						}else if(moneys[i][j]>=sum){
							for(int k=0;k<3;k++){
								moneys[i][j]=moneys[i-1][j];
							}
						}
						tmp=sum;
//						for(int x :moneys[i]){
//							System.out.print(x+" ");
//						}System.out.println();
					}else{
						if(moneys[i][j]==0)continue;
						for(int k=0;k<3;k++){
							moneys[i][j]=moneys[i-1][j];
						}
					}					
				}
			}
			min = Math.min(min, totalpay(moneys[i]));
		}min = Math.min(min, moneys[3][0]);
		return min;
	}

	private static int calcmonth(int[] money, int j) {
		int answer=0;
		for(int i=j;i<j+3;i++){
			answer+=money[i];
		}
		return answer;
	}

	private static boolean isRange(int index, int[] swim,int[] money) {
		if(index>=11)return false;
		boolean answer = true;
		for(int i=index;i<index+3;i++){
			if(swim[i] == 0)return false;
			if(money[i]==0)return false;
		}
		return answer;
	}

}
