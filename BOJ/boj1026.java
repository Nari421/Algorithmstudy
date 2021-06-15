import java.util.Arrays;
import java.util.Scanner;

public class boj1026{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        int min =0;
        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i =0;i<N;i++){
            min+=a[i]*b[N-1-i];
        }
        System.out.println(min);
    }
}
