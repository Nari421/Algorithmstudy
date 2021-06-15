package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testroom = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tester;
        tester = new int[testroom];
        for(int i=0;i<testroom;i++){
            tester[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int General = Integer.parseInt(st.nextToken());
        int Assistant = Integer.parseInt(st.nextToken());


        System.out.println(countSupervisor(tester,General,Assistant));
    }
    private static long countSupervisor(int[] test,int general,int assistant) {
        long supervisor = 0;
        for(int i=0;i<test.length;i++){
            test[i]-=general;
            supervisor++;
            if (test[i] > 0) {
                if(test[i]%assistant==0) {
                    supervisor += (test[i]/assistant);
                }else{
                    supervisor += (test[i]/assistant)+1;
                }
            }
        }
        return supervisor;
    }

//    private static int countGeneral(int general) {
//        int supervisor = 0;
//        for(int i=0;i<tester.length;i++){
//            tester[i]-=general;
//            supervisor++;
//        }
//        return supervisor;
//    }
//    private static int countAssistant(int assistant) {
//        int supervisor = 0,i=0;
//        int size = tester.length;
//        while(size>0){
//            int remain = tester[i]-assistant;
//            if(remain < 0 || remain == 0){
//                ++i;
//                --size;
//            }else{
//                tester[i] = remain;
//            }
//            supervisor++;
//        }
//        return supervisor;
//    }
}
