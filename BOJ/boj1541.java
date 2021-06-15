package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1541 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] num = input.split("-");
        int answer=calc(num[0]);
        for(int i=1;i<num.length;i++){
            answer-=calc(num[i]);
        }
        System.out.println(answer);
    }
    static int calc(String s){
        int ans=0;
        String[] numbers = s.split("\\+");
        for(int i=0;i<numbers.length;i++){
            ans+=Integer.parseInt(numbers[i]);
        }
        return ans;
    }
}
