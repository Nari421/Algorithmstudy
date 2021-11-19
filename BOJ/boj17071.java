package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17071 {
	static int n,k;
	static int[] visit = new int[500001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		if(k >=500000){
			System.out.println(-1);
			return;
		}
		int cnt=0;
		
		
		System.out.println();
	}
	private static void findsister(int x,int y) {
		Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = 1;
        while(!q.isEmpty()){
            int point = q.poll();
            for(int i=0;i<3;i++){
                int nx=0;
                switch (i){
                    case 0:
                        nx = point-1;
                        break;
                    case 1:
                        nx = point+1;
                        break;
                    case 2:
                        nx = point*2;
                        break;
                }
                if(nx == k){
                    System.out.println(visit[point]);
                    return;
                }
                if(0<=nx && nx<visit.length && visit[nx] == 0){
                    q.add(nx);
                    visit[nx] = visit[point]+1;
                }
            }
        }
	}

}
