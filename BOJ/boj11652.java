package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj11652 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        HashMap<Long,Integer> map =new HashMap<>();
        int max=1;
        long answer = 0;
        for(int i=0;i<N;i++){
            long input = Long.parseLong(br.readLine());
            if(map.containsKey(input)){
                map.put(input,map.get(input)+1);
                if(max == map.get(input)){
                    answer = Math.min(answer,input);
                }else if(max<map.get(input)){
                    max = map.get(input);
                    answer = input;
                }
            }else{
                map.put(input,1);
                if(map.size()==1){
                    answer = input;
                }
                if(max == 1){
                    answer = Math.min(answer,input);

                }
            }
        }
        System.out.println(answer);
    }
}
