class Solution {
    public int solution(String s) {
        String[] number = {"0","1","2","3","4","5","6","7","8","9"};
        String[] english = {"zero","one","two","three","four","five","six","seven","eight","nine"};


        for(int i =0; i<10; i++){
            s = s.replaceAll(english[i],number[i]);
        }
        System.out.println(s);
        int answer = Integer.parseInt(s);
        return answer;
    }
}