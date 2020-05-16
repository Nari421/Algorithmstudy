import java.util.*;
class Solution {
    Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        int len = room_number.length;
        answer =  new long[len];
        for(int i=0;i<len;i++){
            answer[i] = hotelroom(room_number[i]);
        }
        return answer;
    }
    public long hotelroom(long room_number){
        if (!map.containsKey(room_number)) {
            map.put(room_number, room_number + 1);
            return room_number;
        }
        
        long anther = map.get(room_number);
        long empty = hotelroom(anther);
        map.put(room_number, empty);
        return empty;
    }
        
}