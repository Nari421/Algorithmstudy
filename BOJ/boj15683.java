import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class boj15683 {
    static List<camera> list = new ArrayList<camera>();
    static int n,m,noneCamera=0,cnt=0;
    static int[][] map,copymap;
    static class camera {
        int x, y;

        public camera(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copymap  = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>=1&&map[i][j]<6) {
                    list.add(new camera(i, j));
                }
            }
        }
        for(camera c : list ){
            watched(c.x,c.y);
        }
    }



    private static void watched(int x, int y) {
        System.out.println(x+" "+y+" / "+map[x][y]);
        int max=0;
        if(map[x][y] ==1){
            copy(map);
            int index =-1;
            for(int i=0;i<4;i++){
                int compare=0;
                switch (i){
                    case 0:
                        compare = right(x,y,copymap);
                        break;
                    case 1:
                        compare = left(x,y,copymap);
                        break;
                    case 2:
                        compare = up(x,y,copymap);
                        break;
                    case 3:
                        compare = down(x,y,copymap);
                }
                if(max < compare){
                    index = i;
                    max = compare;
                }
            }
            
        }else if(map[x][y] == 2){
            copy(map);
            for(int i=0;i<2;i++){
                int compare=0;
//                switch (i){
//                    case 0:
//                        compare = right(x,y)+left(x,y);
//                        break;
//                    case 1:
//                        compare = up(x,y)+down(x,y);
//                        break;
//                }
                max= Math.max(max,compare);
            }

        }
        if(x<n && x>=0 && y<m && y>=0){

        }
    }
    private static int[][] copy(int[][] map) {
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copymap[i], 0, m);
        }
        return copymap;

    }

    private  static int right(int x, int y,int[][] copymap1){
        for (int i = y + 1; m > i; ++i) { // 오른쪽
            if (copymap1[x][i] == 0) {
                ++cnt;
                copymap1[x][i] = -1;
            } else if (copymap1[x][i] == 6) {
                break;
            }
        }
        return cnt;
    }
    private  static int left(int x, int y,int[][] copymap1){
        for (int i = y - 1; 0 <= i; --i) { // 왼쪽
            if (copymap1[x][i] == 0) {
                ++cnt;
                copymap1[x][i] = 9;
            } else if (copymap1[x][i] == 6) {
                break;
            }
        }
        return cnt;
    }
    private  static int up(int x, int y,int[][] copymap1){
        for (int i = x - 1; 0 <= i; --i) { // 위쪽
            if (copymap1[i][y] == 0) {
                ++cnt;
                copymap1[i][y] = 7;
            } else if (copymap1[i][y] == 6) {
                break;
            }
        }
        return cnt;
    }
    private  static  int down(int x, int y,int[][] copymap1){
        for (int i = x + 1; n > i; ++i) { // 아래쪽
            if (copymap1[i][y] == 0) {
                ++cnt;
                copymap1[i][y] = 7;
            } else if (copymap1[i][y] == 6) {
                break;
            }
        }
        return cnt;
    }
}
