import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] prize = {6,6,5,4,3,2,1};
        int zero = 0,win=0,index=0;
        int min=0,max=0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int i=0;i<lottos.length;i++){
        	if(lottos[i] == 0){
        		zero++;
        		continue;
        	}
        	for(int j=index;j<win_nums.length;j++){
        		if(lottos[i] == win_nums[j]){
            		win++;
            		index=j+1;
            		break;
            	}
        	}
        	
        }
        min = win;
        max = zero+win;
        answer[0] = prize[max];
        answer[1] = prize[min];
        
        return answer;
    }
}