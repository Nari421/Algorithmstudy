import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = arr[2] = arr[3] = 1; arr[4]= arr[5] = 2;
        for(int i=0;i<n;i++){
           int ans = Integer.parseInt(br.readLine());
           for(int j=6;j<=ans;j++){
               arr[j] = arr[j-1]+arr[j-5];
               System.out.println(arr[j]);
           }
           System.out.println(arr[ans]);
        }
    }
}
