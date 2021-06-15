import java.util.Scanner;

public class boj9095 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] answer = new int[n];
        int[] array = new int[11];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;
        for(int i=0;i<n;i++){
            int testcase = input.nextInt();
            if(testcase<4) {
                answer[i] = array[testcase];
            }else{
                for(int j=4;j<=testcase;j++){
                    array[j] = array[j-1]+array[j-2]+array[j-3];
                }
                answer[i] = array[testcase];
            }

        }
        for(int ans : answer){
            System.out.println(ans);
        }
    }
}
