import java.util.*;
class Solution {
    public class tuple{
        int before,cur,next;
        public tuple(int before,int cur, int next){
            this.before = before;
            this.cur = cur;
            this.next = next;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        int before[] = new int[n];
        int next[] = new int[n];
        for(int i=0;i<n;i++){
            before[i] = i-1;
            next[i] = i+1;
        }
        next[n - 1] = -1;
        Stack<tuple> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'U') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = before[k];
                }
            } else if(c == 'D') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = next[k];
                }
            } else if(c == 'C') {
                stack.push(new tuple(before[k], k, next[k]));
                if(before[k] != -1) next[before[k]] = next[k];
                if(next[k] != -1) before[next[k]] = before[k];
                sb.setCharAt(k, 'X');
                
                if(next[k] != -1) k = next[k];
                else k = before[k];
            } else {
                tuple t = stack.pop();
                if(t.before != -1) next[t.before] = t.cur; 
                if(t.next != -1) before[t.next] = t.cur;
                sb.setCharAt(t.cur, 'O');
            }
        }
        
        return sb.toString();
    }
}