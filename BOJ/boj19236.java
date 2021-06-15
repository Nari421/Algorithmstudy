package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19236 {
	static int dx[] ={-1,-1,0,1,1,1,0,-1};
	static int dy[] ={0,-1,-1,-1,0,1,1,1};
	static class fish{
		int x,y,num,dir,alive;
		public fish(int num, int x, int y, int dir, int alive){
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.alive = alive;
		}
	}
	static int answer=0;
	static int map[][]= new int [4][4];
	static fish[] fish = new fish[17];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<4;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				map[i][j] = num;
				fish[num] = new fish(num,i,j,dir,1);
			}
		}
		//초기 설정
		int sx =0,sy=0;
		int sd = fish[map[0][0]].dir;
		int eat = map[0][0]; // 0,0물고기 먹음
		fish[map[0][0]].alive = 0; //0,0물고기 죽음
		
		map[0][0] = -1; // 상어 위치
		dfs(sx,sy,sd,eat);
		System.out.println(answer);
	}
	private static void dfs(int sx, int sy, int sd, int eat) {
		answer  = Math.max(answer, eat);
		System.out.println("sx :"+sx+" sy:"+sy+" answer: "+answer+" eat: "+eat);
		int[][] tempMap = new int[map.length][map.length];
		for(int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
		}

		//fish 배열 복사 
		fish[] tempFish = new fish[fish.length];
		for(int i = 1; i <= 16; i++) 
			tempFish[i] = new fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);	

		// 물고기 이동 
		moveFish();
		for(int i = 1; i < 4; i++) { //4*4 행렬로 1칸, 2칸, 3칸까지 최대로 이동 가능
			int nx = sx + dx[sd] * i;
			int ny = sy + dy[sd] * i;

			//경계를 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우 
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) { 
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].dir;
				map[sx][sy] = 0;
				map[nx][ny] = -1;
				fish[eatFish].alive = 0;
				System.out.println(nx+" "+ny+" eatFish : "+eatFish);
				dfs(nx, ny, nd, eat+eatFish);

				fish[eatFish].alive = 1; // 물고기 상태, 상어의 위치 원래대로 되돌리기 
				map[sx][sy] = -1;
				map[nx][ny] = eatFish;
			}
		}

		// 맵 상태, 물고기 정보 되돌리기 
		for(int j = 0; j < map.length; j++)
			System.arraycopy(tempMap[j], 0, map[j], 0, map.length);

		for(int i=1; i<=16; i++)
			fish[i] = new fish(tempFish[i].num, tempFish[i].x, tempFish[i].y, tempFish[i].dir, tempFish[i].alive);
	}
	private static void moveFish(){
		for(int i=1;i<17;i++){
			if(fish[i].alive == 0){
				continue;
			}
			int dir = fish[i].dir;
			for(int j=0;j<8;j++){
				dir%=8;
				fish[i].dir = dir;//옮기고 방향 바뀌었으면 실행
				int nx = fish[i].x+dx[dir];
				int ny = fish[i].y+dy[dir];
				
				if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1){
					if(map[nx][ny] == 0){
						map[fish[i].x][fish[i].y]=0;//빈칸이면 바꾸지 않아도 되니 그냥 이전칸에 0
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i; //물고기 정보 저장
					}else{//물고기가 있는 칸
						//바꿀 물고기 위치 변경
						int tmp = fish[map[nx][ny]].num;
						fish[tmp].x = fish[i].x;
						fish[tmp].y = fish[i].y;
						map[fish[tmp].x][fish[tmp].y] = tmp;
						//현재 물고기 위치 변경
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				}else{
					dir++;
				}
			}
			
		}
	}
}
