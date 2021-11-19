package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1113 {
	static int n,m,pool[][],copy[][];
	 public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pool = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++){
				pool[i][j] =s.charAt(j)-'0';
			}
		}
		int h=10;
		int size=0;
		while(h-->0){
			copy=new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					copy[i][j] = h-pool[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(copy[i][j]+" ");
				}System.out.println();
			}System.out.println();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copy[i][j]>0){
						System.out.println("current : "+i+", "+j);
						size+=water(i,j);
					}
				}
			}
			
		}
		System.out.println(size);
		
	}
	private static int water(int i, int j) {
		boolean flood = false;
        int size = 0;
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{i, j});
        size += 1;
        copy[i][j] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d=0; d<dir.length; d++) {
                int xx = cur[0] + dir[d][0];
                int yy = cur[1] + dir[d][1];
                if(xx>=0 && xx<n &&yy>=0 && yy<m) {
                    if(copy[xx][yy]>0) {System.out.println("current copy: "+xx+", "+yy+" : "+copy[xx][yy]);
                        size += 1;
                        copy[xx][yy] = 0;
                        q.add(new int[]{xx, yy});
                    }
                } else flood = true;
            }
        }
        if(flood) size = 0;
        System.out.println(size);
        return size;
	}

}
