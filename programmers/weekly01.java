import java.util.*;
class Solution {
    public long solution(int price, int money, int count) {
        long tmp=0;
        for(int i=1;i<=count;i++){
            tmp += price*i;
        }
        long answer = tmp-money;
        if(answer<=0)answer=0;
        return answer;
    }
}