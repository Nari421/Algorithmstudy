package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14719 {
	static int h,w,map[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[w];
		for(int i=0;i<w;i++){
			map[i] = Integer.parseInt(st.nextToken());
		}
		int answer=0;
		for(int i=1;i<w-1;i++){
			int left=0,right=0;
			for(int j=0;j<i;j++){
				left = Math.max(left,map[j]);
			}
			for(int j=i+1;j<w;j++){
				right = Math.max(right, map[j]);
			}
			if(map[i]<left && map[i]<right){
				answer+=Math.min(left, right)-map[i];
			}
			
		}
		
		System.out.println(answer);

	}

}
