package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17406 {
	static int n,m,k,matrix[][],r,c,s,min = Integer.MAX_VALUE,list[],p[],matrix_copy[][];
	static int[][] queries;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		matrix = new int[n+1][m+1];
		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		queries = new int[k][4];
		visit = new boolean[k];
		list = new int[k];
		p = new int[k];
		for(int i=0;i<k;i++){
			list[i] = i;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c =Integer.parseInt(st.nextToken());
			s =Integer.parseInt(st.nextToken());
			int start = r-s;
			int mid1 =c-s;
			int mid2 = r+s;
			int end = c+s;
			queries[i][0] = start; queries[i][1] = mid1;
			queries[i][2] = mid2;  queries[i][3] = end;
		}
		
		permutaion(0);
		System.out.println(min);

	}
	private static void permutaion(int index) {
		if(index == k){
			matrix_copy = new int[n+1][m+1];
			for (int i = 1; i <= n; i++) {
	            System.arraycopy(matrix[i], 0, matrix_copy[i], 0, matrix[0].length);
	        }
			for(int i=0;i<k;i++){
				prerotate(queries[p[i]]);
			}System.out.println("순열 끝");
			
			int tmp = countmin();
			min = tmp<min?tmp:min;
			return;
		}for(int i=0;i<k;i++){
			if(visit[i])continue;
			p[i] = list[index];
			visit[i] = true;
			permutaion(index+1);
			visit[i] = false;
		}
		
	}
	private static int countmin() {
		int sum=0,minc=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				sum+=matrix_copy[i][j];
			}
			if(sum<minc){
				minc=sum;
			}sum=0;
		}
		return minc;
	}
	private static void prerotate(int[] q) {
		int start = q[1];
		int mid1 =q[3];
		int mid2 = q[2];
		int end = q[0];
		System.out.println(start+" "+mid1+" "+mid2+" "+end);
		while(start+end<mid2+mid1){
			rotateMatrix(start,mid1,mid2,end);
			start++;mid1--;mid2--;end++;
			
//			for(int i=1;i<=n;i++){
//				for(int j=1;j<=m;j++){
//					System.out.print(matrix_copy[i][j]+" ");
//				}System.out.println();
//			}System.out.println("--------------------\n");
//			
//			System.out.println(start+" "+mid1+" "+mid2+" "+end);
		}
	}
	private static void rotateMatrix(int start, int mid1, int mid2, int end) {
		int rotatecnt  = ((mid2 - end)+(mid1-start))*2;
		int rotate = 0;
		int x = end;
		int y = start;
		int next = matrix_copy[x][y];
		while(rotatecnt>0){
			if(rotate == 0){
				int tmp = matrix_copy[x][y+1];
				matrix_copy[x][++y] =next; 
				next = tmp;
				if(y == mid1){
					rotate=1;
				}
			}else if(rotate == 1){
				int tmp = matrix_copy[x+1][y];
				matrix_copy[++x][y] =next; 
				next = tmp;
				if(x == mid2){
					rotate=2;
				}
			}else if(rotate == 2){
				int tmp = matrix_copy[x][y-1];
				matrix_copy[x][--y] =next; 
				next = tmp;
				if(y == start){
					rotate=3;
				}
			}else if(rotate == 3){
				int tmp = matrix_copy[x-1][y];
				matrix_copy[--x][y] =next; 
				next = tmp;
			}
			rotatecnt--;
		}
		
	}

}
