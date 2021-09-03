class Solution {
    String[] alpha = {"A","E","I","O","U"};
    int answer=0;
    boolean value = false;
    int cnt=0;
    public int solution(String word) {
        String s="";
        
        dfs(s,word);
        return answer;
    }
    public void dfs(String s,String word){
        if(s.length()>5){
            cnt-=1;
            return;
        }
        if(s.equals(word)){
            answer = cnt;
            value = true;
            return;
        }
        for(int i=0;i<alpha.length;i++){
            cnt+=1;
            String str = s+alpha[i]+"";
            dfs(str,word);
            if(value)return;
        }
    }
}