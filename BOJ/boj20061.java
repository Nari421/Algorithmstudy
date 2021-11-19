package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj20061 {
	static int score=0,red[][],blue[][],green[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		green = new int[6][4];
		blue = new int[4][6];
        StringTokenizer st;
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//move(t,x,y);
			moveB(t,x,y);
			moveG(t,x,y);
			checkBlue();
			checkGreen();
			//getscore();
//			pushB(safeareaB());
//			pushG(safeareaG());
		}
		
		System.out.println(score);
		System.out.println(countBlock());
	}

	private static void checkGreen() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=5;i>=2;i--){
			int count=0;
			for(int j=0;j<4;j++){
				if(green[i][j]==1){
					count++;
				}
			}if(count == 4){
				score++;
				list.add(i);				
			}
		}
		if(list.size()>0){
			pushGreen(list);
		}
		list = new ArrayList<>();
		for(int i=1;i>=0;i--){
			for(int j=0;j<4;j++){
				if(green[i][j] == 1){
					list.add(i);
					break;
				}
			}
		}
		if(list.size()>0){
			pushGreen(list);
		}

		
	}

	private static void pushGreen(ArrayList<Integer> list) {
		Collections.reverse(list);
		for(Integer li : list){
			if(li>1){
				for(int i=li;i>0;i--){
					for(int j=0;j<4;j++){
						green[i][j] = green[i-1][j];
					}
				}for (int i = 0; i < 4; i++) {
					green[0][i] = 0;
				}
			}else{
				for(int i=5;i>0;i--){
					for(int j=0;j<4;j++){
						green[i][j] = green[i-1][j];
					}
				}for (int i = 0; i < 4; i++) {
					green[0][i] = 0;
				}
			}
		}
		
	}

	private static void checkBlue() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=5;i>=2;i--){
			int count=0;
			for(int j=0;j<4;j++){
				if(blue[j][i]==1){
					count++;
				}
			}if(count == 4){
				score++;
				list.add(i);				
			}
		}
		if(list.size()>0){
			pushBlue(list);
		}
		list = new ArrayList<>();
		for(int i=1;i>=0;i--){
			for(int j=0;j<4;j++){
				if(blue[j][i] == 1){
					list.add(i);
					break;
				}
			}
		}
		if(list.size()>0){
			pushBlue(list);
		}
		
	}

	private static void pushBlue(ArrayList<Integer> list) {
		Collections.reverse(list);
		for(Integer li : list){
			if(li>1){
				for(int i=li;i>0;i--){
					for(int j=0;j<4;j++){
						blue[j][i] = blue[j][i-1];
					}
				}
				for (int i = 0; i < 4; i++) {
					blue[i][0] = 0;
				}
			}else{
				for(int i=5;i>0;i--){
					for(int j=0;j<4;j++){
						blue[j][i] = blue[j][i-1];
					}
				}
				for (int i = 0; i < 4; i++) {
					blue[i][0] = 0;
				}
			}
		}
		
	}

	private static int countBlock() {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				if (blue[i][j] == 1)
					count++;
				if (green[j][i] == 1)
					count++;
			}
		}
		return count;
	}
	
//	private static void pushG(int cnt) {
//		for(int i=5;i>=2;i--){
//			for(int j=0;j<4;j++){
//				green[i][j] =green[i-cnt][j]; 
//			}
//		}
//		for(int i=0;i<2;i++){
//			for(int j=0;j<4;j++){
//				green[i][j]=0;
//			}
//		}
//	}
//	private static void pushB(int cnt) {
//		for(int i=5;i>=2;i--){
//			for(int j=0;j<4;j++){
//				blue[j][i] =blue[j][i-cnt]; 
//			}
//		}
//		for(int i=0;i<2;i++){
//			for(int j=0;j<4;j++){
//				blue[j][i]=0;
//			}
//		}
//	}
//	private static int safeareaG() {
//		int cnt=0;
//		for(int i=0;i<2;i++){
//			for(int j=0;j<4;j++){
//				if(green[i][j]==1){
//					cnt++;break;
//				}
//			}
//		}
//		return cnt;
//	}
//	private static int safeareaB() {
//		int cnt=0;
//		for(int i=0;i<2;i++){
//			for(int j=0;j<4;j++){
//				if(blue[j][i]==1){
//					cnt++;break;
//				}
//			}
//		}
//		return cnt;
//	}
//	private static void getscore() {
//		for(int i=5;i>=2;i--){
//			int count=0;
//			for(int j=0;j<4;j++){
//				if(green[i][j]==0){
//					break;
//				}else{
//					count++;
//				}
//			}if(count == 4){
//				score++;
//				cleanG(i);
//				i++;
//				
//			}
//		}
//		for(int i=5;i>=2;i--){
//			int count=0;
//			for(int j=0;j<4;j++){
//				if(blue[j][i]==0){
//					break;
//				}else{
//					count++;
//				}
//			}if(count == 4){
//				score++;
//				cleanB(i);
//				i++;
//				
//			}
//		}
//	}
//	private static void cleanB(int line) {
//		for(int i=line;i>0;i--){
//			for(int j=0;j<4;j++){
//				blue[i][j] = blue[i-1][j];
//			}
//		}
//		
//	}
//	private static void cleanG(int line) {
//		for(int i=line;i>0;i--){
//			for(int j=0;j<4;j++){
//				green[i][j] = green[i-1][j];
//			}
//		}
//		
//	}
//	private static void move(int t,int x,int y){
//		if(t == 1){
//			int col = 0;
//			for(int i=0;i<=5;i++){
//				if(blue[x][i] == 0){
//					col=i;
//				}else break;
//			}
//			int row = 0;
//			for(int i=0;i<=5;i++){
//				if(green[i][y] == 0){
//					row=i;
//				}else break;
//			}
//			green[row][y] = 1;
//			blue[x][col] = 1;
//		}else if(t == 2){
//			int col = 0;
//			for(int i=1;i<=5;i++){
//				if(blue[x][i] == 0 && blue[x][i-1]==0){
//					col=i;
//				}else break;
//			}
//			int row = 0;
//			for(int i=0;i<=5;i++){
//				if(green[i][y] == 0 && green[i][y+1]==0){
//					row=i;
//				}else break;
//			}
//			green[row][y] = 1;
//			green[row][y+1]=1;
//			blue[x][col] = 1;
//			blue[x][col-1]=1;
//		}else if(t==3){
//			int col = 0;
//			for(int i=0;i<=5;i++){
//				if(blue[x][i] == 0 && blue[x+1][i]==0){
//					col=i;
//				}else break;
//			}
//			int row = 0;
//			for(int i=1;i<=5;i++){
//				if(green[i][y] == 0 && green[i-1][y]==0){
//					row=i;
//				}else break;
//			}
//			green[row][y] = 1;
//			green[row-1][y]=1;
//			blue[x][col] = 1;
//			blue[x+1][col]=1;
//		}
//	}
	private static void moveB(int t, int x, int y) {
		if(t == 1){
			int col = 0;
			for(int i=0;i<=5;i++){
				if(blue[x][i] == 0){
					col=i;
				}else break;
			}
			blue[x][col] = 1;
		}else if(t == 2){
			int col = 0;
			for(int i=1;i<=5;i++){
				if(blue[x][i] == 0 && blue[x][i-1]==0){
					col=i;
				}else break;
			}
			blue[x][col] = 1;
			blue[x][col-1]=1;
		}else if(t==3){
			int col = 0;
			for(int i=0;i<=5;i++){
				if(blue[x][i] == 0 && blue[x+1][i]==0){
					col=i;
				}else break;
			}
			blue[x][col] = 1;
			blue[x+1][col]=1;
		}
	}
	private static void moveG(int t,int x,int y) {
		if(t == 1){
			int row = 0;
			for(int i=0;i<=5;i++){
				if(green[i][y] == 0){
					row=i;
				}else break;
			}
			green[row][y] = 1;
		}else if(t == 2){
			int row = 0;
			for(int i=0;i<=5;i++){
				if(green[i][y] == 0 && green[i][y+1]==0){
					row=i;
				}else break;
			}
			green[row][y] = 1;
			green[row][y+1]=1;
		}else if(t==3){
			int row = 0;
			for(int i=1;i<=5;i++){
				if(green[i][y] == 0 && green[i-1][y]==0){
					row=i;
				}else break;
			}
			green[row][y] = 1;
			green[row-1][y]=1;
		}
	}

}
