package boj;

import java.io.*;
import java.util.PriorityQueue;

public class boj1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        for(int i=0;i<N;i++){
            card[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(card,N));
    }
    private static int solution(int[] card,int N){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(card[i]);
        }
        int x,y,sum=0;
        while(pq.size()>1){
            x = pq.poll();
            y = pq.poll();
            sum+=x+y;
            pq.add(x+y);
        }
        return sum;
    }
//static int n, v, ans = 0;
//    static PriorityQueue<Integer> pq = new PriorityQueue<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        n = Integer.parseInt(br.readLine());
//        while (n-- != 0) {
//            v = Integer.parseInt(br.readLine());
//            pq.offer(v);
//        }
//        while (pq.size() != 1) {
//            int p = pq.poll(), q = pq.poll();
//            ans += p + q;
//            pq.offer(p + q);
//        }
//        bw.write(ans + "\n");
//        bw.flush();bw.close();
//    }
}
