package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj10816 {
    private static int[] card1,card2;
    public static void main(String[] arg)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        card1 = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            ++card1[Integer.parseInt(st.nextToken())+10000000] ;
        }
        int N = Integer.parseInt(br.readLine());
//        card2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            s.append(card1[Integer.parseInt(st.nextToken())+10000000]+" ");
        }
        System.out.println(s);
//        String ans="";
//        for(int i : card2){
//            int left = findleft(card1,0, card1.length,i);
//            int right = findright(card1,0, card1.length,i);
//
//            ans+=(right-left)+" ";
//        }
//        System.out.println(ans);
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//        int[] card = new int[20000001];
//        for (int i = 0; i < N; ++i) {
//            ++card[sc.nextInt()+10000000] ;
//        }
//        int M = sc.nextInt();
//
//        for (int i = 0; i < M; ++i) {
//            sb.append(card[sc.nextInt()+10000000]+" ");
//        }
//        System.out.println(sb.toString());
    }
    private static int findleft(int[] arr,int left, int right,int i){
        int index = (left + right) / 2;
        if(left >= right) {
            return index;
        }
        if( arr[index] >= i ) {
            return findleft(arr, left, index, i);
        }else {
            return findleft(arr, index + 1, right, i);
        }
    }
    private static int findright(int[] arr,int left, int right,int i){
        int index = (left + right) / 2;
        if(left >= right) {
            return index;
        }
        if( arr[index] <= i ) {
            return findright(arr, index + 1, right, i);
        }else {
            return findright(arr, left, index, i);
        }
    }
}
