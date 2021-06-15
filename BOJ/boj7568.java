import java.util.*;
public class baekjoon7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] aura = new int[n][2];
        int[] answer = new int[n];
        for (int i = 0; i <n ; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();

            aura[i][0] = weight;
            aura[i][1] = height;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;;
                if(aura[i][0] < aura[j][0] && aura[i][1]<aura[j][1])answer[i]++;
            }
        }

        for(int i : answer){
            System.out.println(++i);
        }
    }
}
