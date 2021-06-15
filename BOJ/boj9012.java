import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class baekjoon9012 {
    public static void main(String[] args) throws IOException {
//           BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int n = Integer.parseInt(br.readLine());
//        int i;
//        while(n-->0) {
//            boolean isVPS = true;
//            String input = br.readLine();
//            Stack<Character> stack = new Stack<Character>();
//            char temp;
//            for(i=0; i<input.length(); i++) {
//                temp = input.charAt(i);
//                if(temp == '(') {
//                    stack.push(temp);
//                }
//                else if(temp == ')') {
//                    if(!stack.isEmpty()) {
//                        stack.pop(); }
//                    else {
//                        isVPS = false;
//                        break;
//                    }
//                }
//            }
//            if(!stack.isEmpty())
//                isVPS = false;
//            if(isVPS) {
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
//        }
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        while (input-- >0) {
            Stack<Character> stack = new Stack<>();
            String inputStr = br.readLine();
            boolean check = true;
            char temp;
                for(int j=0;j<inputStr.length();j++) {
                    temp = inputStr.charAt(j);
                    if (temp == '(') {
                        stack.push(temp);
                    } else if (temp == ')') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            check = false;
                            break;
                        }
                    }
                }
            if(!stack.isEmpty()) check = false;

            if(check) {System.out.println("Yes");}
            else {System.out.println("No");}
        }
//        String[] answer = new String[input];
//        String[] strings = new String[input];
//        boolean check =true;
//        for(int i=0;i<input;i++) {
//            String str = sc.next();
//            strings[i] = str;
//        }
//        for(int i=0;i<input;i++){
//            int len = strings[i].length();
//            for(int j=0;j<len;j++) {
//                if(strings[i].charAt(j) == '('){
//                    stack.push(strings[i].charAt(j));
//                } else if (strings[i].charAt(j) == ')' && !stack.isEmpty()) {
//                    stack.pop();
//                } else if(strings[i].charAt(j) == ')' && stack.isEmpty()){
//                    check = false;
//                    break;
//                }
//
//            }
//            if(stack.isEmpty() && check){
//                answer[i] = "Yes";
//            }else{
//                answer[i] = "No";
//            }
//            check =true;
//            stack.clear();
//        }
//        for(String ans : answer){
//            System.out.println(ans);
//        }
//
//        int check = 0;
//        for(int i=0;i<input;i++){
//            String str = sc.next();
//            int len = str.length();
//            for(int j=0;j<len;j++) {
//                if (str.charAt(j) == '(') {
//                    stack.push(str.charAt(j));
//                } else if (str.charAt(j) == ')' && !stack.isEmpty()) {
//                    stack.pop();
//                } else if(str.charAt(j) == ')' && stack.isEmpty()){
//                    check++;
//                    break;
//                }
//            }
//            if(stack.isEmpty() && check ==0){
//                System.out.println("Yes");
//            }else{
//                System.out.println("No");
//            }
//            check =0;
//            stack.clear();
//        }
    }
}
//   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int n = Integer.parseInt(br.readLine());
//        int i;
//        while(n-->0) {
//            boolean isVPS = true;
//            String input = br.readLine();
//            Stack<Character> stack = new Stack<Character>();
//            char temp;
//            for(i=0; i<input.length(); i++) {
//                temp = input.charAt(i);
//                if(temp == '(') {
//                    stack.push(temp);
//                }
//                else if(temp == ')') {
//                    if(!stack.isEmpty()) {
//                        stack.pop(); }
//                    else {
//                        isVPS = false;
//                        break;
//                    }
//                }
//            }
//            if(!stack.isEmpty())
//                isVPS = false;
//            if(isVPS) {
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
//        }