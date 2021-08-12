import java.util.*;
class Solution {
    static int min = 0,row,column;
	static int[][] matrixs;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrixs =new int[rows+1][columns+1];
        int cnt=1;
        for(int i=1;i<=rows;i++){
        	for(int j=1;j<=columns;j++){
        		matrixs[i][j] = cnt++;
        	}
        }
        min = cnt;
        row =rows; column = columns;
        for(int i=0;i<queries.length;i++){
        	rotateMatrix(queries[i][1],queries[i][3],queries[i][2],queries[i][0]);
        	answer[i] = min;
        }
        return answer;
    }
    private static void rotateMatrix(int start, int mid1, int mid2, int end) {
		int rotatecnt  = ((mid2 - end)+(mid1-start))*2;
		int rotate = 0;
		int x = end;
		int y = start;
		int next = matrixs[x][y];
		min=row*column;
		while(rotatecnt>0){
			min = min<next?min:next;
			if(rotate == 0){
				int tmp = matrixs[x][y+1];
				matrixs[x][++y] =next; 
				next = tmp;
				if(y == mid1){
					rotate=1;
				}
			}else if(rotate == 1){
				int tmp = matrixs[x+1][y];
				matrixs[++x][y] =next; 
				next = tmp;
				if(x == mid2){
					rotate=2;
				}
			}else if(rotate == 2){
				int tmp = matrixs[x][y-1];
				matrixs[x][--y] =next; 
				next = tmp;
				if(y == start){
					rotate=3;
				}
			}else if(rotate == 3){
				int tmp = matrixs[x-1][y];
				matrixs[--x][y] =next; 
				next = tmp;
			}
			rotatecnt--;
		}
		
	}
}