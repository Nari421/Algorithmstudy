import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {

            int day = i + T[i];     // i번째 날의 상담기간
            System.out.println(day+" /i : "+i);
            if (day <= N + 1){
                dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
                System.out.println("dp["+i+"] "+dp[i]+" / (P["+i+"]"+(P[i] +"dp["+day+"])" +dp[day])+" / dp[i + 1]: "+dp[i + 1]);
            }
            else {    // 상담일 초과
                System.out.println(dp[i]);
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
//    static int[] T;
//    static int[] P;
//    static int answer=0;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st ;
//        int N = Integer.parseInt(br.readLine());
//        T = new int[N];
//        P = new int[N];
//
//        for(int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine());
//            T[i] = Integer.parseInt(st.nextToken());
//            P[i] = Integer.parseInt(st.nextToken());
//        }
//        dfs(0,0,N);
//        System.out.println(answer);
//    }
//
//    private static void dfs(int index, int value,int N) {
//        if(index>=N){
//            answer = Math.max(answer,value);
//            return;
//        }
//        if(index+T[index]<=N){
//            dfs(index+T[index],value+P[index],N);
//        }else{
//            dfs(index+T[index],value,N);
//        }
//
//        dfs(index+1,value,N);
//    }

}
