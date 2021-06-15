import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1987 {
    static int R,C,max=1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] board;
    static HashSet<Character> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        board = new char[R][C];
        String input="";
        for(int i=0;i<R;i++){
            input = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = input.charAt(j);
                set.add(input.charAt(j));
            }
        }
        System.out.println(set);
        set.remove(board[0][0]);
        for(int i=0;i<4;i++){
            int ans = dfs(0,0,1);
            System.out.println(ans);
        }


    }
    static int dfs(int x, int y,int compare){
        if(set.isEmpty()) {
            return max;
        }
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<R &&ny>=0 &&ny<C){
                if(set.contains(board[nx][ny])){
                    System.out.println(board[nx][ny]+" / board["+nx+"]["+ny+"]");
                    set.remove(board[nx][ny]);
                    compare++;

                    dfs(nx,ny,compare);
                    max = Math.max(max,compare);
                    System.out.println(set+" / max : "+max);
                    set.add(board[nx][ny]);
                }
            }

        }
        return max;
    }
}
