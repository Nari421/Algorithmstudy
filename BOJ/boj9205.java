package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205 {
    static class Dot{
        int x;
        int y;
        public Dot(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T,n;
    static LinkedList<Dot> list;
    static int[] check ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int testcase=0; testcase<T;testcase++){
            n = Integer.parseInt(br.readLine());
            list = new LinkedList<Dot>();
            check = new int[n + 2];
            for(int i=0;i<n+2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                list.add(new Dot(x,y));
            }
            bfs();
        }
    }
    public static void bfs(){
        Queue<Dot> q = new LinkedList<Dot>();
        boolean success = false;
        q.offer(list.get(0));
        while(!q.isEmpty()){
            Dot d = q.poll();
            if(d.equals(list.get(n+1))){
                success =true;
                break;
            }
            for(int i=1;i<n+2;i++){
                Dot d1 = list.get(i);
                int x = Math.abs(d.x-d1.x);
                int y = Math.abs(d.y-d1.y);
                if(check[i] == 0 && (x+y)<=1000){
                    q.add(d1);
                    check[i]=1;
                }
            }
        }
        if(success){
            System.out.println("happy");
        }else{
            System.out.println("sad");
        }
    }
}
