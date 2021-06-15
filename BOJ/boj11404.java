package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11404 {
    public static void main(String[] args) throws Exception {
        final int INF = 100 * 100_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] root = new int[n+1][n+1];

        for(int i = 0 ; i <= n; i++)
            Arrays.fill(root[i], INF);

        for(int i = 1; i <= n; i++)
            root[i][i] = 0;
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            root[x][y] = Math.min(cost, root[x][y]);
        }
        for(int i = 1; i <= n; i++){//경유
            for(int j = 1; j <= n; j++){//출발
                if(i != j) {
                    for (int k = 1; k <= n; k++) {//도착
                        // 시작노드 != 도착노드 && 도착노드 != 경유노드
                        if(j != k && i != k){
                            // 기존의 값 보다 경유한 값이 작은 경우
                            if(root[j][k] > root[j][i] + root[i][k]){
                                root[j][k] = root[j][i] + root[i][k];
                            }
                        }
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(root[i][j]+" ");
            }System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append((root[i][j] != INF ? root[i][j] : 0) + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
