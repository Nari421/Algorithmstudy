import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon2961 {
    ArrayList<Integer> list = new ArrayList<>();
    static int mul = 1;
    static int sum = 0;
    static int min = 0;
    static int[] s;
    static int[] b;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cook = sc.nextInt();
        s = new int[cook];
        b = new int[cook];

        for (int i = 0; i < cook; i++) {
            int inputS = sc.nextInt();
            int inputB = sc.nextInt();
            s[i] = inputS;
            b[i] = inputB;
        }
        for (int i = 0; i < cook; i++) {
            findMin(s, b, i);
        }
        System.out.println(min);

    }

    public static int findMin(int[] s, int[] b, int index) {
        for(int i=index;i<s.length;i++){
            for(int j=index+1;j<s.length;j++){

            }
        }
        mul *= s[index];
        sum += b[index];
        if (Math.abs(mul - sum) < min) min = Math.abs(mul - sum);
        return findMin(s, b, index + 1);
    }
}
