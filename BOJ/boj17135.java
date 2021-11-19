package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17135 {
	static int[] dx = {0, 0, 0};
    static int[] dy = {0, -1, 1};
    private static int n = 0, m = 0, d = 0, line = 0;
    private static int Max = -1;
    private static boolean[] Archer;
    private static int[][] castle;
    static boolean[][] visit;
    static Queue<info> infoq = new LinkedList<>(); 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        Archer = new boolean[m];
        castle = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0);
        System.out.println(Max);

    }

    private static void combination(int index, int count) {
        if (count == 3) {
        	visit = new boolean[n][m];
        	line=0;
            depends();
            int tmp = counts();
            Max = Max>tmp?Max:tmp;
            return;
        }
        for (int i = index; i < m; i++) {
            if (!Archer[i]) {
                Archer[i] = true;
                combination(i + 1, count + 1);
                Archer[i] = false;
            }
        }
    }

    private static int counts() {
    	int ans=0;
		for(boolean[] i:visit){
			for(boolean j:i){
				if(j == true)ans++;
			}
		}
		return ans;
	}

	private static void depends() {
//    	
//		System.out.println();
//    	for(int i=0;i<m;i++){
//        	System.out.print(Archer[i]+" ");
//        }System.out.println();
//        
    	while(line<n){
    		for(int i=0;i<m;i++){
            	if(Archer[i]){
            		int nr = n-line;
            		int nc = i;
            		kills(nr,nc);
            		
            	}
            }
    		while(!infoq.isEmpty()){
    			info in = infoq.poll();
    			visit[in.r][in.c] = true;
    		}
    		line++;
//            System.out.println("--------------------vvv------------");
//            for(int i=0;i<n;i++){
//            	for(int j=0;j<m;j++){
//            		System.out.print(visit[i][j]+" ");
//            	}System.out.println();
//            }
//            System.out.println("--------------------------------");
    	}
    }

	private static void kills(int nr, int nc) {
		ArrayList<info> list = new ArrayList<>();
		for(int r=(n-line-1);r>=0 ;r--){
			for(int c=0;c<m;c++){
				if(castle[r][c]==0)continue;
				int dis =  Math.abs(r-nr)+Math.abs(c-nc);
				if(d>=dis && castle[r][c]==1 && !visit[r][c]){
					list.add(new info(dis,r,c));
				}
			}
		}
		if(!list.isEmpty()){
			Collections.sort(list,new infocom3());
			Collections.sort(list,new infocom2());
			Collections.sort(list,new infocom());
			int mind = list.get(0).d;
			int minr = list.get(0).r;
			int minc = list.get(0).c;
			System.out.println(mind + " "+minr+" "+minc);
			infoq.add(new info(mind,minr,minc));
		}
	}
	static class info{
		int d,r,c;
		public info(int d,int r,int c){
			this.d = d;
			this.r = r;
			this.c = c;
		}
	}
	static class infocom implements Comparator<info>{
		@Override
		public int compare(info p1,info p2) {
			if(p1.d>p2.d) return 1;
			if(p1.d<p2.d) return -1;
			return 0;
		}
	}
	static class infocom2 implements Comparator<info>{
		@Override
		public int compare(info p1,info p2) {
			if(p1.c>p2.c) return 1;
			if(p1.c<p2.c) return -1;
			return 0;
		}
	}
	static class infocom3 implements Comparator<info>{
		@Override
		public int compare(info p1,info p2) {
			if(p1.r<p2.r) return 1;
			if(p1.r>p2.r) return -1;
			return 0;
		}
	}

}
