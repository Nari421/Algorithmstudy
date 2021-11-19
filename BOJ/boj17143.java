package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class boj17143 {
	static int R,C,M,catches=0;
	static class fish implements Comparable<fish>{
		int num,r,c,s,d,z,kill;
		public fish(int num,int r, int c,int s,int d,int z,int kill){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d= d;
			this.z =z;
			this.kill = kill;
			this.num =num;
		}
		@Override
		public int compareTo(fish f){
			return f.z-this.z;
		}
	}
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,1,-1};
	static ArrayList<fish> flist = new ArrayList<>();
	static ArrayList<fish>[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				map[i][j] = new ArrayList<>();
			}
		}
		if(M==0){
			System.out.println("0");
			return;
		}
		for(int i=0;i<M;i++){
			st  = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			fish f =new fish(i,r,c,s,d,z,1);
			flist.add(f);
			map[r][c].add(f);
		}
		int king=0;
		while(king < C){
			fishing(king);
			move();
			doubleCheck();
			king++;
		}
		System.out.println(catches);
		
		
	}
	private static void doubleCheck() {
		ArrayList<fish> list = new ArrayList<>(flist);
		Collections.sort(list);
		for(fish f:list){
			System.out.println(f.r+" "+f.c+" f.z"+f.z+" "+f.kill);
			if(f.kill==0)continue;
			if(map[f.r][f.c].size()>=1){
				f.kill=0;
				int num =f.num;			
				System.out.println(f.z);
				flist.set(num, f);
			}else{
				map[f.r][f.c].add(f);
			}
			
		}
		System.out.println("move");
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(map[i][j].size()==0){
					System.out.print("0\t");
				}else{
					System.out.print(map[i][j].get(0).z+"\t");
				}
				
			}System.out.println();
		}
		
		
	}
	private static void move() {
		for(fish f: flist){
			if(f.kill==0){
				continue;
			}
			int speed = f.s;
			int nr = f.r;
			int nc = f.c;
			int nd = f.d;
			//원래자리 비우기
			map[nr][nc].clear();
			
			//System.out.println("origin : "+nr+ " "+nc+" "+nd+" "+speed);
			while(speed>0){
				nr+=dr[nd];
				nc+=dc[nd];
				if(nr<0||nc<0||nr>=R||nc>=C){
					nr-=dr[nd];
					nc-=dc[nd];
					nd = nd%2==0?nd-1:nd+1;
					//System.out.println(" "+nr+" "+nc+" "+nd);
					continue;
				}
				speed--;
			}
			System.out.println("after : "+nr+ " "+nc+" "+nd+" "+f.z);
			f.r = nr;
			f.c = nc;
			f.d = nd;
			System.out.println("after2 : "+f.r+ " "+f.c+" "+f.d+" "+f.z);

		}
		for(fish f:flist){
			System.out.println(f.r+ " "+f.c+" "+f.d+" "+f.z);
		}
	}
	private static void fishing(int king) {
		for(int i=0;i<R;i++){
			if(map[i][king].size()==0)continue;
			if(map[i][king].get(0).z!=0 && map[i][king].get(0).kill==1){
				fish f = map[i][king].get(0);
				catches+=map[i][king].get(0).z;
				f.kill=0;
				int num=f.num;
				flist.set(num, f);
				map[i][king].clear();
				System.out.println(" hunt "+i+" "+king+" "+catches);
				return;
			}
		}
		
	}

}
