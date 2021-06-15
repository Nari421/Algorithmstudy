package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int number = Integer.parseInt(br.readLine());
            if(pq.size() == 0 && number == 0){
                System.out.println(0);
            }else{
                if(number==0){
                    System.out.println(pq.poll());
                }else{
                    pq.add(number);
                }
            }

        }
    }
}
