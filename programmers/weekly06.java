package prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class weekly06 {

	public static void main(String[] args) {
		int[] weights ={50,82,75,120};
		String[] head2head={"NLWL","WNLL","LWNW","WWLN"};
//		int[] weights ={60,70,60};
//		String[] head2head={"NNN","NNN","NNN"};
		System.out.println(solution(weights,head2head));

	}
	static class play {
		int player,weight,over, score;
		public play(int player,int weight,int score,int over){
			this.player = player;
			this.weight = weight;
			this.score = score;
			this.over = over;
		}
	}
	
	static class scorecom implements Comparator<play>{
		@Override
		public int compare(play p1,play p2) {
			if(p1.score<p2.score) return 1;
			if(p1.score>p2.score) return -1;
			return 0;
		}
	}
	static class overcom implements Comparator<play>{
		@Override
		public int compare(play p1,play p2) {
			if(p1.over<p2.over) return 1;
			if(p1.over>p2.over) return -1;
			return 0;
		}
	}
	static class weightcom implements Comparator<play>{
		@Override
		public int compare(play p1,play p2) {
			if(p1.weight<p2.weight) return 1;
			if(p1.weight>p2.weight) return -1;
			return 0;
		}
	}
	
	static ArrayList<play> list = new ArrayList<>();
	//static int s[],w[],o[];
	public static int[] solution(int[] weights, String[] head2head) {
		int len = weights.length;
		int[] answer=new int[len];
		//s = w=o=new int[len];
		for(int i=0;i<len;i++){
			String result=head2head[i];
			int win=0,compare=0,n=0;
			double avg=0;
			for(int j=0;j<len;j++){
				if(result.charAt(j) == 'W'){
					win++;
					if(weights[j]>weights[i])compare++;
				}else if(result.charAt(j)=='N'){
					n++;
				}
			}
			avg = (win/(len-n-1));
			list.add(new play(i+1,weights[i],(int)avg,compare));
		}
		
		Collections.sort(list,new weightcom());
		Collections.sort(list,new overcom());
		Collections.sort(list,new scorecom());
		
		for(play p:list){
			System.out.println(p.player+" "+p.over+" "+p.score+" "+p.weight);
		}
		
		return answer;
	}
}
