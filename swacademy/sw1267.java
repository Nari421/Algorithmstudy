package swAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw1267 {
	static int V,E,map[][],degree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1;t<=10;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			map = new int[V+1][V+1];
			degree = new int[V+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				degree[y]++;
			}
			Queue<Integer> q = new LinkedList();
			for(int i=1;i<=V;i++){
				if(degree[i]==0)q.add(i);
			}
			System.out.print("#"+t+" ");
			while(!q.isEmpty()){
				int value = q.poll();
				System.out.print(value+" ");
				for(int i=1;i<=V;i++){
					if(map[value][i]==1){
						degree[i]--;
						if(degree[i]==0)q.add(i);
					}
				}
			}
			System.out.println();
		}

	}

}
