package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2941 {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        list.add("c=");list.add("c-");list.add("dz=");
        list.add("d-");list.add("lj");list.add("nj");
        list.add("s=");list.add("z=");
        for(int i=0;i<list.size();i++){
            input=input.replace(list.get(i),"0");
        }
        System.out.println(input.length());
//        int answer=0,i=0;
//        while(i<input.length()){
//            if(i == input.length()-1){
//                answer++;
//                break;
//            }
//            String str = input.charAt(i)+""+input.charAt(i+1)+"";
//            if(str.equals("dz")){
//                if(i+2 != input.length()&&input.charAt(i+2)=='='){
//                    System.out.println("str : "+str);
//                    str+=input.charAt(i+2)+"";
//                    i++;
//                }
//            }
//            if(list.contains(str)){
//                i++;
//                answer++;
//            }else{
//                answer++;
//            }
//            i++;
//        }

        //System.out.println(answer);
    }
}
