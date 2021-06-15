package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*가장 긴 증가하는 수열 12738번으로 변경*/
public class boj14003 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N=Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] input = new int [N];
//        for(int i=0;i<N;i++){
//            input[i] = Integer.parseInt(st.nextToken());
//            System.out.println(input[i]);
//        }
//
//
//    }
private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 증가수열을 저장할 리스트
        List<Integer> list = new ArrayList<>();
        // 입력된 값을 저장할 배열
        int arr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // 확인하는 숫자가 증가수열의 마지막 수보다 큰 경우
            // 수열에 추가해준다.
            if(num > list.get(list.size() - 1)) list.add(num);
                // 확인하는 숫자가 증가수열의 마지막 수보다 작은 경우
            else{
                // 숫자의 적당한 위치를 찾아
                // 증가수열의 값을 변경해준다.
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        // 최장 길이 출력
        System.out.println(list);
        sb.append(list.size() - 1 + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class boj14003 {
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        // 이분탐색을 통해 증가하는 수열을 저장할 객체
//        List<Integer> list = new ArrayList<>();
//        // 입력된 수열을 저장
//        int arr[] = new int[n + 1];
//        // 입력된 각 수열의 위치를 저장
//        int indexArr[] = new int[n + 1];
//
//        // 수열을 입력받아 저장한다.
//        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
//
//        list.add(Integer.MIN_VALUE);
//
//        for(int i = 1 ; i <= n; i++){
//            int num = arr[i];
//            int left = 1;
//            int right = list.size() - 1;
//
//            // 확인하는 숫자가 수열의 마지막 수보다 큰 경우
//            // 수열에 추가해준다.
//            if(num > list.get(list.size() - 1)) {
//                list.add(num);
//                indexArr[i] = list.size() - 1;
//            }
//            // 확인하는 숫자가 수열의 마지막 수보다 작은 경우
//            else{
//                while(left < right){
//                    int mid = (left + right) >> 1;
//
//                    if(list.get(mid) >= num) right = mid;
//                    else left = mid + 1;
//                }
//                list.set(right, num);
//                indexArr[i] = right;
//            }
//        }
//        // 최장 길이 출력
//        sb.append(list.size() - 1 + "\n");
//        // 역추적 경로를 저장할 stack
//        Stack<Integer> stack = new Stack();
//
//        // 현재 찾길 원하는 증가수열의 인덱스 값
//        int index = list.size() - 1;
//
//        for(int i = n; i > 0; i--){
//            // 찾길 원하는 인덱스와 같은 경우
//            if(indexArr[i] == index){
//                // 찾길 원하는 인덱스를 하나 감소시킨다.
//                // 다음 인덱스의 값을 찾기 위해서
//                index--;
//                // stack에 경로를 추가한다.
//                stack.push(arr[i]);
//            }
//        }
//
//        // 스택에서 꺼내며 찾는다.
//        while (!stack.isEmpty()){
//            sb.append(stack.pop() + " ");
//        }
//
//        bw.write(sb.toString());
//        bw.close();
//        br.close();
//    }
//}
