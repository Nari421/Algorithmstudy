import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> memberMap = new HashMap<>();

        for(int i=0; i < enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            memberMap.put(enroll[i], i);
        }

        for(int i=0; i<seller.length; i++){

            String name = seller[i];
            int money = 100 * amount[i];
            
            while(!name.equals("-")){
                int profitForParent = money / 10; 
                int nowProfit = money - profitForParent; 

                answer[memberMap.get(name)] += nowProfit;

                name = parentMap.get(name);
                money /= 10;

                if (money < 1) {
                    break;
                }
            }
        }

        return answer;
    }
}