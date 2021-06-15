package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for(String s:str){
            if(!s.equals("")){
                list.add(s);
            }
        }
        System.out.println(list.size());
    }
}
