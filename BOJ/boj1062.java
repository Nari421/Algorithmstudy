package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1062 {
	static int n,k,len,max=0;
	static char must[] = {'a','n','t','i','c'};
	static String fix_s="";
	static boolean[] visit;
	static HashSet<Character> fix = new HashSet<>();
	static ArrayList<Character>[] charlist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(k<5){
			System.out.println(0);
			return;
		}else if(k==26){
			System.out.println(n);
			return;
		}
		charlist = new ArrayList[n];
		for(int i=0;i<n;i++){
			String input = br.readLine();
			charlist[i] = new ArrayList<>();
			for(int j=0;j<input.length();j++){
				fix.add(input.charAt(j));
				
				if(!charlist[i].contains(input.charAt(j))){
					charlist[i].add(input.charAt(j));
				}
			}
			
		}
		for(int i=0;i<must.length;i++){
			fix.remove(must[i]);
		}
		fix_s = fix.toString().replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]","");
		fix_s =fix_s.replace(" ", "");
		
		//조합
		len = k-5;
		visit = new boolean[fix.size()];
		combination(0,0);
		System.out.println(max);
		
	}
	private static void combination(int index,int start) {
			if(index == len){
				int tmp = teaches();
				max = tmp<max?max:tmp;
				
				return;
			}for(int i=start;i<fix.size();i++){
				visit[i] = true;
				combination(index+1,i+1);
				visit[i] = false;
			}
	}
	private static int teaches() {
		int cnt=0;
		for(int i=0;i<visit.length;i++){
			if(visit[i] == true){
				cnt+=checkwords(fix_s.charAt(i));
			}
		}
		return cnt;
	}
	private static int checkwords(char c) {
		int cnt=0;
		for(int i=0;i<charlist.length;i++){
			if(charlist[i].contains(c)){
				cnt++;
			}
		}
		return cnt;
	}

}
