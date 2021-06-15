import java.util.Arrays;
import java.util.Scanner;

public class boj11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] customer = new int[N];
        for(int i =0; i<N; i++) {
            customer[i] = sc.nextInt();
        }
        Arrays.sort(customer);
        int sum=0;
        int min=0;
        for(int i=0;i<customer.length;i++){
            min +=customer[i];
            sum +=min;
        }
        System.out.println(sum);
    }
}
