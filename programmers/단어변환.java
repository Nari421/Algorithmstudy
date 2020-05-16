import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer=0;
        for (String word : words) {
			if (word.equals(target)) {
				answer = 1;
				break;
			}
		}
		if (answer != 1) {
			answer = 0;
			return 0;
		}
        answer=bfs(0,begin,target,words,0);
        
        return answer;
    }
    public int bfs(int index,String begin,String target,String[] words,int stage) {
        int answer=0;
        int pre=1;
        Queue<String> q = new LinkedList<String>();
        q.offer(begin);
        
        while (!q.isEmpty()) {
            String tmp = q.remove();
            if(tmp.equals(target)) break;
            ++stage;
            for(String s : words){
                int diff =0 ;
                for(int i=0;i<begin.length();i++){
                    if(tmp.charAt(i)!=s.charAt(i)){
                        ++diff;
                    }
                    if(diff>1){
                        break;
                    }
                }
                if(diff ==1){
                    q.offer(s);
                    ++index;
                }
            }
            if(stage == pre){
                pre = index;
                index = 0;
                stage = 0;
                ++answer;
            }
            if(answer>words.length){
                answer=0;
                break;
            }
        }
        return answer;
    }
}