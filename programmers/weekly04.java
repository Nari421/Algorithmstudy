import java.util.*;
class Solution {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max=0;
        for(int i=0;i<table.length;i++){
            String[] str = table[i].split(" ");
            int score=0;
            for(int j=0;j<languages.length;j++){
            	for(int k=1;k<str.length;k++){
            		if(languages[j].equals(str[k])){
            			score+=(6-k)*preference[j];
            		}
            	}
            }
            if(score == max){
            	if(answer.compareTo(str[0]) > 0) {
    				answer = str[0];
    			}
            }else if(score>max){
            	max=score;
            	answer = str[0];
            }
        }
        
        return answer;
    }
}