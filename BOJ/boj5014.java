package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
    static int F,S,G,U,D;
    static int[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visit =new int[F+1];
        bfs(S);
    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[S] = 1;
        while(!q.isEmpty()){
            int point = q.poll();
            if(point == G){
                System.out.println(visit[point]-1);
                return;
            }
            for(int i=0;i<2;i++){
                int nx=0;
                switch (i){
                    case 0:
                        nx = point+U;
                        break;
                    case 1:
                        nx = point-D;
                        break;
                }
                if(0<nx && nx<=F && visit[nx] == 0){
                    q.add(nx);
                    visit[nx] = visit[point]+1;
                }
            }
        }
        System.out.println("use the stairs");
        return;
    }
}
