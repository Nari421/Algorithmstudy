package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<>(); 
		for (int i = 0; i < str.length(); i++) { 
			list.add(str.charAt(i)); 
		}

		int n = Integer.parseInt(br.readLine());
		int cursor = list.size();
		for(int i=0;i<n;i++){
			String cmd = br.readLine();
			if(cmd.charAt(0) == 'L'){
				if(cursor !=0){
					cursor--;
				}
			}else if(cmd.charAt(0) == 'D'){
					if(cursor !=list.size()){
						cursor++;
					}
			}else if(cmd.charAt(0) == 'P'){
				list.add(cursor,cmd.charAt(2));
				cursor++;
			}else if(cmd.charAt(0) == 'B'){
				if(cursor !=0){
					list.remove(cursor-1);
					cursor--;
				}
			}
		}
		str="";
		for(Character c : list){
			str+=c;
		}
		System.out.println(str);
	}

}
