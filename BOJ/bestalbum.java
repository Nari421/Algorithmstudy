import java.util.*;

public class bestalbum {
    public static void main(String[] args) {
        String[] genres={"classic","pop","classic","classic","pop"};
        int[] plays = {500,600,150,800,2500};
        int[] result;

        solution(genres,plays);

    }
    public static void solution(String[] genres, int[] plays){
        HashMap<Integer, String> total = new HashMap<>();
        HashMap<Integer, String> gmap = new HashMap<>();
        HashMap<Integer, Integer> pmap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            pmap.put(i, plays[i]);
            gmap.put(i, genres[i]);
        }
        HashSet<String> gSet = new HashSet<String>();

        for(int i = 0; i < genres.length; i++){
            gSet.add(genres[i]);
        }

        //장르별 총 플레이 횟수
        for(String x : gSet){
            int count = 0;
            for(int i = 0; i < gmap.size(); i++){
                if(gmap.get(i).equals(x)){
                    count+= pmap.get(i);
                }
            }
            total.put(count, x);

        }

        TreeMap sort = new TreeMap(total);
        String[] sortGenre = new String[gSet.size()];
        int index = 0;
        for(Object o : sort.keySet()){
            sortGenre[index] = sort.get(o).toString();
            index++;
        }

        ArrayList<Integer> fIndex = new ArrayList<Integer>();
        for(int i = sortGenre.length-1; i >= 0; i--){
            int count = 0;
            for(int p1 : gmap.keySet()){
                if(sortGenre[i].equals(gmap.get(p1))){
                    count++;
                }
            }

            int[] temp = new int[count];
            int k = 0;
            for(int p2 : gmap.keySet()){
                if(sortGenre[i].equals(gmap.get(p2))){
                    temp[k] = pmap.get(p2);
                    k++;
                }
            }

            if(temp.length != 1){
                Arrays.sort(temp);
                for(int j = temp.length - 1; j >= temp.length - 2; j--){
                    for(int p : pmap.keySet()){
                        if(temp[j] == pmap.get(p)){
                            fIndex.add(p);
                            pmap.put(p, 0);
                            break;
                        }
                    }
                }
            }else{
                for(int p : pmap.keySet()){
                    if(temp[0] == pmap.get(p)){
                        fIndex.add(p);
                        pmap.put(p, 0);
                        break;
                    }
                }
            }
        }

        int[] answer = new int[fIndex.size()];

        for(int i = 0; i < fIndex.size(); i++){
            answer[i] = fIndex.get(i);
            System.out.println(answer[i]);
        }
        //System.out.println(answer);
        //return answer;
    }


//        for(int i=0;i<genres.length;i++){
//            if(total.containsKey(genres[i])){
//                total.replace(genres[i],total.get(genres[i])+plays[i]);
//            }else
//                total.put(genres[i], plays[i]);
//        }


        //return answer;

}
