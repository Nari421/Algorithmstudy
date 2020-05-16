import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int a = A.length-1;
        int b = B.length-1;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=a;i>=0;i--){
            if(A[a]<B[b]){
                b--;
                ++answer;
            }
            a--;
        }
        return answer;
    }
}