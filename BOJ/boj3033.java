import java.util.Arrays;
import java.util.Scanner;

public class baekjoon3033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next().toLowerCase();

        while(true){
            if(str.length() != L){
                str = sc.next().toLowerCase();
            }else{
                break;
            }
        }

        char[] chs = str.toCharArray();
        char[] test = Arrays.copyOfRange(chs,1,4);
        for(int i=0;i<test.length;i++){

            System.out.println(test[i]);
        }
        for(int i=0;i<L;i++){
            for(int j=i+1;j<L;j++){

            }
        }

    }
}
