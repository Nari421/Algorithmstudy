import java.util.Scanner;

public class baekjoon5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int exchange = 1000-money;
        int coin =0,i=0;
        int[] ex_coin = {500,100,50,10,5,1};
        while(exchange>0){
            if(exchange>=ex_coin[i]){
                coin += exchange/ex_coin[i];
                exchange = exchange - (ex_coin[i]*(exchange/ex_coin[i]));
                System.out.println(ex_coin[i]+" :"+coin);

            }i++;
//            if(exchange>=100){
//                coin += exchange/100;
//                exchange = exchange - (100*(exchange/100));
//                System.out.println("100 :"+coin);
//            }
//            if(exchange>=50){
//                coin += exchange/50;
//                exchange = exchange - (50*(exchange/50));
//                System.out.println("50 :"+coin);
//            }
//            if(exchange>=10){
//                coin += exchange/10;
//                exchange = exchange - (10*(exchange/10));
//                System.out.println("10 :"+coin);
//            }
//            if(exchange>=5){
//                coin += exchange/5;
//                exchange = exchange - (5*(exchange/5));
//                System.out.println("5 :"+coin);
//            }
//            if(exchange>=1){
//                coin += exchange/1;
//                exchange = exchange - (1*(exchange/1));
//                System.out.println("1 :"+coin);
//            }
        }
        System.out.println(coin);
    }
}
