import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 각 종류별 입을 수 있는 옷을 조합해서 서로 다른 옷의 조합 수를 return
        // 의상 이름, 의상 종류 -> 종류별 의상이 몇 개인지 파악
        // 조합 -> nCm
        // 의상 종류만큼 : n개 중 1개 or 0개를 선택할 확률 -1 (모두 선택하지 않을 확률)
            // 선택할 확률 : 의상 종류 + 1(선택 안 할 확률) 전체 구하고 -1
        // 의상 종류 수만 필요한 것이므로 Map 활용
        
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