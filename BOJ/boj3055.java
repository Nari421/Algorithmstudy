package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055 {
//	static int R; // R행
//	static int C; // C열
//	static char[][] map; // 숲의 정보
//	static boolean[][] visited;// 방문 관리
//	static int minCnt; // 최소 시간
//	static int[] dy = { -1, 1, 0, 0 };
//	static int[] dx = { 0, 0, -1, 1 };
//	static Queue<Pos> moveQ = new LinkedList<Pos>();
//	static Queue<Pos> waterQ = new LinkedList<Pos>();
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		R = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//
//		map = new char[R][C];
//		visited = new boolean[R][C];
//		minCnt = Integer.MAX_VALUE;
//		for (int i = 0; i < R; i++) {
//			String str = br.readLine();
//			for (int j = 0; j < C; j++) {
//				char c = str.charAt(j);
//				map[i][j] = c;
//				// 고슴도치의 위치
//				if (c == 'S') {
//					moveQ.offer(new Pos(i, j));
//					visited[i][j] = true;
//				}
//				// 물의 위치
//				else if (c == '*') {
//					waterQ.offer(new Pos(i, j));
//				}
//			}
//		}
//
//		// 이동 횟수
//		int move = 0;
//		while (!moveQ.isEmpty()) {
//			spread(); // 물이 찰 예정인 칸으로 이동이 불가하므로 먼저 실행.
//			for(int i=0;i<R;i++){
//				for(int j=0;j<C;j++){
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}System.out.println("------------------------------");
//			bfs(++move); // 고슴도치의 이동
//		}
//
//		System.out.println(minCnt == Integer.MAX_VALUE ? "KAKTUS" : minCnt);
//		br.close();
//	}
//
//	// 고슴도치의 이동 탐색
//	private static void bfs(int move) {
//		int cnt = moveQ.size();
//
//		// 기존의 크기 동안
//		while (cnt-- > 0) {
//			Pos pos = moveQ.poll();
//			int row = pos.row;
//			int col = pos.col;
//
//			// 4방 탐색
//			for (int d = 0; d < 4; d++) {
//				int nextRow = row + dy[d];
//				int nextCol = col + dx[d];
//
//				// 범위 검사 && 고슴도치의 이동 가능 검사
//				if (isIn(nextRow, nextCol) && isMove(nextRow, nextCol)) {
//
//					// 비버의 굴 발견
//					if (map[nextRow][nextCol] == 'D') {
//						minCnt = move; // 최소값 탐색 완료
//						moveQ.clear(); // 호출하는 곳의 while문 조건을 위한 Queue 초기화
//						return; // 종료
//					}
//
//					// 방문한적이 없는 경우
//					if (!visited[nextRow][nextCol]) {
//						moveQ.offer(new Pos(nextRow, nextCol)); // 임시 Queue에 삽입
//						visited[nextRow][nextCol] = true; // 방문 체크
//					}
//				}
//			}
//		}
//	}
//
//	// 물을 채울 곳을 탐색
//	private static void spread() {
//		int cnt = waterQ.size();
//
//		// 기존의 크기 동안
//		while (cnt-- > 0) {
//			Pos waterPos = waterQ.poll();
//			int row = waterPos.row;
//			int col = waterPos.col;
//
//			// 4방 탐색
//			for (int d = 0; d < 4; d++) {
//				int nextRow = row + dy[d];
//				int nextCol = col + dx[d];
//
//				// 범위 검사 && 물이 찰 수 있는 경우
//				if (isIn(nextRow, nextCol) && map[nextRow][nextCol] == '.') {
//					waterQ.offer(new Pos(nextRow, nextCol));
//					map[nextRow][nextCol] = '*';
//				}
//			}
//		}
//	}
//
//	// 고슴도치의 이동 가능 여부
//	private static boolean isMove(int row, int col) {
//		if (map[row][col] == '.' || map[row][col] == 'D') {
//			return true;
//		}
//		return false;
//	}
//
//	// 범위 검사
//	private static boolean isIn(int row, int col) {
//		if (row < 0 || row >= R || col < 0 || col >= C) {
//			return false;
//		}
//		return true;
//	}
//
//}
//
//class Pos {
//	int row;
//	int col;
//
//	public Pos(int row, int col) {
//		this.row = row;
//		this.col = col;
//	}

	static int R, C, startR,startC,arrR,arrC,min=Integer.MAX_VALUE;
	static char[][] map;
	static boolean visit[][];
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static class dot{
    	int x, y;
    	public dot(int x,int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    static Queue<dot> animal = new LinkedList<>();
    static Queue<dot> water = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++){
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c  = s.charAt(j);
				map[i][j] = c;
				if(c == '*'){
					water.add(new dot(i,j));
				}else if(c == 'D'){
					arrR = i;arrC = j;
				}else if(c == 'S'){
					startR = i;startC = j;
					animal.add(new dot(i,j));
				}
			}
		}
		visit = new boolean[R][C];
		int cnt=1;
		while(!animal.isEmpty()){
			spreadWater();
			bfs(cnt++);
		}
		System.out.println(min == Integer.MAX_VALUE?"KAKTUS":min);
		

	}

	private static void bfs(int cnt) {
		int size = animal.size();
		while(size-- >0){
			dot d = animal.poll();
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;

				if (!visit[nx][ny] && map[nx][ny] == '.') {
					visit[nx][ny] = true;
					animal.add(new dot(nx, ny));
				}
				if (map[nx][ny] == 'D') {
					min = Math.min(min, cnt);
					animal.clear();
					return;
				}
			}
		}
	}
	private static void spreadWater() {
		int size = water.size();
		while(size-->0){
			dot d = water.poll();
			for(int i=0;i<4;i++){
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				if(nx<0 || ny<0 || nx>=R || ny>=C )continue;
				
				if(map[nx][ny]=='.'){
					map[nx][ny]='*';
					water.add(new dot(nx,ny));
				}
			}
		}
	}

}
