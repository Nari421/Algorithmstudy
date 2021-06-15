package boj;
/*
* 부녀회장이 될거야?
* 재귀를 활용해서 해결
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1662 {
    public static void main(String[] arg) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for(int i=0;i<t;i++){
//            int k = Integer.parseInt(br.readLine());
//            int n = Integer.parseInt(br.readLine());
//            System.out.println(calc(k,n));
//        }
        String str = "abcdefg";
        int[] test = {1,2,3,4,5,6,7,8};
        System.out.println(str.substring(3,5));
    }


    private static int calc(int k, int n) {
        int res =0;
        if(k==0) return n;
        else{
            for(int i=1;i<=n;i++){
                res+=calc(k-1,i);
            }
        }
        return res;
    }
}
