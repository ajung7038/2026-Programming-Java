import java.util.Map;
import java.util.HashMap;
import java.lang.Math;
import java.util.Iterator;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        
        // want map 생성
        // <종류, 개수>
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 종류 확인 (discount와 비교)
        for (int i=0; i<10; i++) {
            wantMap.put(discount[i], wantMap.getOrDefault(discount[i], 0) -1);
        }
        
        // value가 0인 것들 삭제
        Iterator<Map.Entry<String, Integer>> iterator = wantMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
            }
        }
        
        // i=1, j=10
        int i=0; int j=9; // 투포인터
        // wantMap 비교하며 <종류, 개수> 일치하는지 확인
        while (j<discount.length) {
            if (i > 0) {
                String obj1 = discount[i-1];
                String obj2 = discount[j];
                wantMap.put(discount[i-1], wantMap.getOrDefault(obj1, 0) +1);
                wantMap.put(discount[j], wantMap.getOrDefault(obj2, 0) -1);
                if (wantMap.containsKey(obj1) && wantMap.get(obj1) == 0) wantMap.remove(obj1);
                if (wantMap.containsKey(obj2) && wantMap.get(obj2) == 0) wantMap.remove(obj2);
            }
            
            if (wantMap.size() == 0) result++;
            i++; j++;
        }
            
        return result;
    }
}