import java.util.Scanner;

public class boj1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] chase = new char[8][8];
        int cnt =0;
        for(int i=0;i<8;i++){
            String input = sc.next();
            for(int j=0;j<8;j++) {
                chase[i][j] = input.charAt(j);
                if(chase[i][j]=='F' && (i+j)%2==0)cnt++;
            }
        }
        System.out.println(cnt);
    }
}
