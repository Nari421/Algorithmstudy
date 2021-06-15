package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1946 {
    static int T,N,pass=1;
    static class junior{
        int paper,interview;
        public junior(int paper,int interview){
            this.paper = paper;
            this.interview = interview;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T>0){
            N = Integer.parseInt(br.readLine());
            ArrayList<junior> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new junior(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list, new Comparator<junior>() {
                @Override
                public int compare(junior o1, junior o2) {
                    return o1.paper < o2.paper ? -1 : 1;
                }
            });
            int first = list.get(0).interview;
            for(int i=1;i<list.size();i++){
                int applicant = list.get(i).interview;
                if(first<applicant){
                    continue;
                }
                if(first>applicant){
                    first = applicant;
                    pass++;
                }
            }
            System.out.println(pass);
            T--;
            pass=1;
        }


    }
}
