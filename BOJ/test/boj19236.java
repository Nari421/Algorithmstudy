package boj.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어부터 16236
public class boj19236 {
    private static int n,map[][],shark=2,eat=0,time=0;
    private static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static class fish{
        int x,y,dist;
        public fish(int x,int y,int dist){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int posx=0,posy=0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    posx = i;posy = j;
                    map[i][j] =0;
                }
            }
        }
        while(true){
            LinkedList<fish> littlefish = new LinkedList<>();
            Queue<fish> sharkpostion = new LinkedList<>();
            sharkpostion.offer(new fish(posx,posy,0));
            visit = new boolean[n][n];
            visit[posx][posy] = true;
            while(!sharkpostion.isEmpty()){
                fish shark_pos = sharkpostion.poll();
                for(int i=0;i<4;i++){
                    int nx = shark_pos.x+dx[i];
                    int ny = shark_pos.y+dy[i];
                    if(nx<0||ny<0||nx>=n||ny>=n)continue;
                    if(visit[nx][ny] == true)continue;
                    if(1<=map[nx][ny] && map[nx][ny]<shark){
                        littlefish.offer(new fish(nx,ny, shark_pos.dist+1));
                        sharkpostion.offer(new fish(nx,ny,shark_pos.dist+1));
                        visit[nx][ny] = true;
                    }else if(map[nx][ny] == 0 || map[nx][ny]==shark){//지나가는 경우
                        sharkpostion.offer(new fish(nx,ny,shark_pos.dist+1));
                        visit[nx][ny] = true;
                    }
                }
            }
            if(littlefish.size() == 0){
                System.out.println(time);
                return;
            }
            fish eatfish = littlefish.get(0);
            for(int i=1;i<littlefish.size();i++){
                if(eatfish.dist>littlefish.get(i).dist){
                    eatfish = littlefish.get(i);
                }
                if(eatfish.dist==littlefish.get(i).dist){
                    if(eatfish.y>littlefish.get(i).y){
                        eatfish = littlefish.get(i);
                    }
                }
            }
            time+=eatfish.dist;
            eat++;
            map[eatfish.x][eatfish.y] = 0;

            if(eat == shark){
                shark++;
                eat=0;
            }

            posx = eatfish.x;
            posy = eatfish.y;
        }

    }

//    private static int n,fistcount=0,sharksize=2,time=0;
//    private static int[][] map;
//    static int[] dx = {1,-1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static class Position{
//        int x,y,dist;
//        public Position(int x,int y,int dist){
//            this.x = x;
//            this.y = y;
//            this.dist = dist;
//        }
//    }
//    static LinkedList<Position> fish;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        map = new int[n][n];
//        int posx =0,posy=0;
//        for(int i=0;i<n;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j=0;j<n;j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//                if(map[i][j] == 9){
//                    posx = i;
//                    posy = j;
//                    map[i][j] = 0;
//                }
//            }
//        }
//        while(true){
//            fish = new LinkedList<Position>();
//            Queue<Position> q = new LinkedList<Position>();
//            q.offer(new Position(posx,posy,0));
//            boolean[][] visit = new boolean[n][n];
//            visit[posx][posy] = true;
//            while(!q.isEmpty()){
//                Position pos = q.poll();
//                for(int i=0;i<4;i++){
//                    int nx = pos.x+dx[i];
//                    int ny = pos.y+dy[i];
//
//                    if(isRange(nx,ny)) continue;
//                    if(visit[nx][ny] == true) continue;
//
//                    if(1<=map[nx][ny] && map[nx][ny]<sharksize){
//                        q.offer(new Position(nx,ny,pos.dist+1));
//                        fish.add(new Position(nx,ny,pos.dist+1));
//                        visit[nx][ny] = true;
//                    }else if(map[nx][ny] == sharksize || map[nx][ny] == 0){
//                        //먹을수 없지만 지나갈수 있는 경우
//                        q.offer(new Position(nx,ny,pos.dist+1));
//                        visit[nx][ny] = true;
//                    }
//
//                }
//            }
//            //if size is 0, nothing to eat.
//            if(fish.size() == 0){
//                System.out.println(time);
//                return;
//            }
//            //먹을 물고기 있는 경우
//            Position eatingfish = fish.get(0);
//            for(int i=1;i<fish.size();i++){
//                if(fish.get(i).dist<eatingfish.dist){
//                    eatingfish  = fish.get(i);
//                }
//                if(eatingfish.dist == fish.get(i).dist){
//                    if(eatingfish.x>fish.get(i).x){
//                        eatingfish  = fish.get(i);
//                    }
//                }
//            }
//            time+=eatingfish.dist;
//            fistcount++;
//            map[eatingfish.x][eatingfish.y] = 0; //물고기 먹은 자리 0으로 갱신
//
//            if(fistcount == sharksize){
//                sharksize++;
//                fistcount=0;
//            }
//            posx = eatingfish.x;
//            posy = eatingfish.y;
//
//        }
//    }
//    public static boolean isRange(int x, int y) {
//        return x < 0 || x >= n || y < 0 || y >= n;
//    }
}
