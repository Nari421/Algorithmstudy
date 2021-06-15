package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class boj11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusq = new PriorityQueue<>();
        PriorityQueue<Integer> minusq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0;i<N;i++){
            int number = Integer.parseInt(br.readLine());
            if(number==0){
                if(plusq.size() ==0 && minusq.size()==0){
                    System.out.println(0);
                }else if(plusq.size() ==0 && minusq.size() !=0){
                    System.out.println(minusq.poll());
                }else if(plusq.size() !=0 &&minusq.size()==0){
                    System.out.println(plusq.poll());
                }else{
                    int minusmin = Math.abs(minusq.peek());
                    int plusmin = Math.abs(plusq.peek());
                    int remove = (minusmin<=plusmin)?minusq.poll():plusq.poll();
                    System.out.println(remove);
                }
//                System.out.println(minusq);
//                System.out.println(plusq);
            }else if(number<0){
                minusq.add(number);
            }else{
                plusq.add(number);
            }
        }
    }
}
