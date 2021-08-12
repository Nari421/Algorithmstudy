import java.util.*;
class Solution {
    static class dot{
        int r,c;
        public dot(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        char c;
        for(int i=0;i<5;i++){
            LinkedList<dot> people = new LinkedList<dot>();
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    c = places[i][j].charAt(k);
                    if(c == 'P'){
                        people.add(new dot(j,k));
                    }
                }
            }
            boolean ispossible = true;
            for(dot d : people){
                ispossible = checkDistance(i,d.r,d.c,places[i]);
                if(ispossible == false){
                    answer[i] = 0;
                    break;
                }
            }
            if(ispossible == true){
                answer[i] = 1;
            }
        }
        return answer;
    }
    public boolean checkDistance(int index,int r,int c,String[] s){
        boolean answer = true;
        Queue<dot> q = new LinkedList<dot>();
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        q.add(new dot(r,c));
        while(!q.isEmpty()){
        	dot d = q.poll();
        	for(int i=0;i<4;i++){
        		int nr = d.r+dr[i];
        		int nc = d.c+dc[i];
        		
        		int manhatan = Math.abs(r-nr)+Math.abs(c-nc);
        		if(nr<0 || nc<0||nr>=5||nc>=5)continue;
        		if(visited[nr][nc] || manhatan>2)continue;
        		
        		visited[nr][nc] = true;
        		if(s[nr].charAt(nc)=='X')continue;
        		else if(s[nr].charAt(nc)=='P')return false;
        		else q.add(new dot(nr,nc));
        		
        	}
        }
        return answer;
    }
}