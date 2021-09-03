import java.util.*;
class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int row = scores.length;
        int col = scores[0].length;
        int mine[] = new int[row];
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<row;i++){
            mine[i]=scores[i][i];
            scores[i][i] =-1;
            int value[] = new int[row];
            for(int j=0;j<col;j++){
                value[j] = scores[j][i];
            }
            map.put(i,value);
        }
        for(int i=0;i<row;i++){
            int tmp[] = map.get(i);
            int sum=0,zero=0;
            Arrays.sort(tmp);
            if(mine[i]<tmp[1] || mine[i]>tmp[row-1]){
                tmp[0] = 0;
                zero=1;
            }else{
                tmp[0] = mine[i];
            }
            for(int j=0;j<row;j++){
                sum+=tmp[j];
            }
            int avg = sum/(col-zero);
            answer+=calscore(avg)+"";
        }
        return answer;
    }
    public String calscore(int score) {
        if(score>=90){
            return "A";
        }else if(score>=80 && score<90){
            return "B";
        }else if(score>=70 && score<80){
            return "C";
        }else if(score>=50 && score<70){
            return "D";
        }else{
            return "F";
        }
    }
}