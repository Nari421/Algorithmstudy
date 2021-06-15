package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj14891 {
    private static HashMap<Integer,String> saw = new HashMap<>();
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=4;i++){
            saw.put(i,br.readLine());
        }
        k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());
            roundSaw(num,di);
        }
        int answer = 0;
        for(int i=1;i<=4;i++){
            char c = saw.get(i).charAt(0);
            if(c == '1'){
                answer+=Math.pow(2,i-1);
            }
        }
        System.out.println(answer);

    }

    private static void roundSaw(int num,int dir) {
        char indexR = saw.get(num).charAt(2);
        char indexL = saw.get(num).charAt(6);
        moveSaw(num,dir);
        int i=num+1,di=dir;
        while(i<5) {
            char idx6 = saw.get(i).charAt(6);
            if (indexR != idx6) {
                indexR = saw.get(i).charAt(2);
                switch (di){
                    case -1:
                        moveSaw(i,1);
                        di = 1;
                        break;
                    case 1:
                        moveSaw(i,-1);
                        di = -1;
                        break;
                }
            }else {
                break;
            }
            i++;
        }
        i=num-1;
        di=dir;
        System.out.println(indexL);
        System.out.println(i);
        while(i>0){
            char idx2 = saw.get(i).charAt(2);
            System.out.println(idx2);
            if(indexL != idx2){
                indexL = saw.get(i).charAt(6);
                if(di == -1){
                    moveSaw(i,1);
                    di = 1;
                }else {
                    moveSaw(i,-1);
                    di = -1;
                }
            }else{
                break;
            }
            i--;
        }

    }

    private static void moveSaw(int num,int di) {
        String s = saw.get(num);
        if(di ==1){
            char c1 = s.charAt(7);
            s = c1+s.substring(0,7);
            System.out.println("시계방향 : "+s);
        }else{
            char c = s.charAt(0);
            s = s.substring(1,8)+c;
           System.out.println("반시계방향 : "+s);
        }
        saw.put(num,s);
    }
}
