import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            int result = check(s,i);
            len = Math.min(result,len);
        }
        return len;
    }
    private static int check( String s , int size ) {
		
		String result= "";
		
		List<String> words = new ArrayList<String>();
		
		int exist = s.length()%size;
		
		for ( int i = 0 ; i <= s.length()-size; i+=size ) {
			words.add(s.substring(i,i+size));
            
		}
		int cnt = 1 ;
		for ( int i = 0 ; i < words.size()-1 ; i ++ ) {
			if ( words.get(i).equals(words.get(i+1))) {
				cnt++;
			} else {
				if ( cnt > 1 ) result = result + String.valueOf(cnt) + words.get(i) ;
				else result += words.get(i);
				
				cnt = 1;
			}
		}
		
		if ( cnt > 1 ) result = result + String.valueOf(cnt) + words.get(words.size()-1);
		else result += words.get(words.size()-1);
		
		return result.length()+exist;
	}
	
}