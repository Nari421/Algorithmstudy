import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int min = Integer.MAX_VALUE,N=0,map[][];
    public int solution(int n, int[][] wires) {
        N=n;
        map = new int[n+1][n+1];
        for(int i=0;i<n-1;i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            map[v1][v2] = map[v2][v1]=1;
        }

        for(int i=0;i<n-1;i++){
            bfs(wires[i][0],wires[i][1]);
        }
        return min;
    }
    private static void bfs(int v1, int v2) {
        boolean visit[] =new boolean[N+1];
        visit[v1] = true;
        visit[v2] = true;
        int cnt = 2;
        ArrayList<Integer> list = new ArrayList<>();
        while(cnt-->0){
            Queue<Integer> q = new LinkedList<Integer>();
            int tmp=1;
            if(cnt==1)q.add(v1);
            else q.add(v2);
            while(!q.isEmpty()){
                int v = q.poll();
                for(int i=1;i<=N;i++){
                    if(map[v][i]==1 && !visit[i]){
                        q.add(i);
                        visit[i] =true;
                        tmp++;
                    }
                }
            }
            list.add(tmp);
        }
        min = Math.min(min, Math.abs(list.get(0)-list.get(1)));
    }
}