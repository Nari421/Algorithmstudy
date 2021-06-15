package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.

어떤 좌석의 배치가 SLLLLSSLL일때, 컵홀더를 *로 표시하면 아래와 같다.

*S*LL*LL*S*S*LL*
SSSS 4
*SSSLLS*
*S*S*S*S* 4
*S*S*S*LL*S* 6
 */
public class boj2810 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N  = Integer.parseInt(br.readLine());
            String inputseat = br.readLine();
            int answer = N+1;
            int cuple=0;
            for(int i=0;i<inputseat.length();i++){
                if(inputseat.charAt(i)=='L'){
                    cuple++;
                }
            }
            if(cuple==0){
                --answer;
            }else{
                answer -=(cuple/2);
            }
            System.out.println(answer);
        }
}
