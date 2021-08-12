import java.util.*;
class Solution {
    static Queue<String> q = new LinkedList<String>();
    static HashSet<String> set = new HashSet<String>(); 
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int start = 0;
        int end = Integer.MAX_VALUE;
        int point =0;
        for(String g : gems){
            set.add(g);
        }
        for(int i=0;i<gems.length;i++){
            if(!map.containsKey(gems[i])) map.put(gems[i], 1);
        	else map.put(gems[i], map.get(gems[i]) + 1);
            
            q.add(gems[i]);
            while(true) {
                String temp = q.peek();

                if (map.get(temp) > 1) {
                    map.put(temp, map.get(temp) - 1);
                    q.poll();
                    point++;
                }else {
                    break;
                }
            }
            
            if(map.size() == set.size() && end>q.size() ){
                end = q.size();
                start = point;
            }
        }
        answer[0] = start+1;
        answer[1] = start+end;
        return answer;
    }
}