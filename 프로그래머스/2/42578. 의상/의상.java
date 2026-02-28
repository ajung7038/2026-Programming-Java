import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 종류별 의상 개수 구하기
        // <의상 종류, 의상 종류별 개수>
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        
        // 2. 조합 개수 return
        int count = 1;
        for (int clothCount : map.values()) {
            count *= (clothCount+1);
        }
        
        // 전부 다 선택하지 않을 확률 제거 (-1)
        return count-1;
    }
}