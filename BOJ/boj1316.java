import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj1316 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] str = new String[input];
        for(int i=0;i<input;i++){
            str[i] = br.readLine();
        }
        HashSet<Character> hs;
        boolean check = true;
        int ans =0;
        for(int i=0;i<str.length;i++){
            hs = new HashSet<>();
            for(int j=0;j<str[i].length();j++){
                if(hs.isEmpty() || !hs.contains(str[i].charAt(j))){
                    hs.add(str[i].charAt(j));
                    check = true;
                }else if(hs.contains(str[i].charAt(j)) && str[i].charAt(j-1)==str[i].charAt(j)){
                    check = true;
                    continue;
                }else{
                    check = false;
                    break;
                }
            }
            if(check)ans++;
        }
        System.out.println(ans);
    }
}
