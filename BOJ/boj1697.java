package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1697 {
    static int N=0,K=0;
    static int[] visit = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K){
            System.out.println(0);
        }
        else{
            findSister(N);
        }
//        int c=0;
//        for(int i : parent){
//            System.out.println(c+++": "+i);
//        }
        Stack<Integer> stack = new Stack<>();
        int index = K;

        while (index != N) {
            stack.push(index);
            index = parent[index];
        }
        stack.push(index);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    static void findSister(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = 1;
        int cnt=0;
        while(!q.isEmpty()){
            int point = q.poll();
            for(int i=0;i<3;i++){
                int nx=0;
                switch (i){
                    case 0:
                        nx = point-1;
                        break;
                    case 1:
                        nx = point+1;
                        break;
                    case 2:
                        nx = point*2;
                        break;
                }
                if(nx == K){
                    parent[nx] = point;
                    System.out.println(visit[point]);
                    return;
                }
                if(0<=nx && nx<visit.length && visit[nx] == 0){
                    q.add(nx);
                    visit[nx] = visit[point]+1;
                    parent[nx] = point;
                    //System.out.println(parent[nx]+" "+cnt+++" "+nx);
                }
            }
        }

    }
}
