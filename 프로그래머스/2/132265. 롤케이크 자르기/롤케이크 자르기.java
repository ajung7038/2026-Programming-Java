import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        
        // <토핑종류, 개수>
        // 토핑 원소를 모두 돌면서 Map에 각 토핑별 사이즈 구하기
        Map<Integer, Integer> map = new HashMap<>();
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        
        // 종류 비교
        Map<Integer, Integer> personMap = new HashMap<>();
        for (int i=0; i<topping.length-1; i++) {
            int top = topping[i];
            personMap.put(top, personMap.getOrDefault(top, 0) + 1);
            int toppingSize = map.get(top)-1;
            if (toppingSize == 0) map.remove(top);
            else map.put(top, toppingSize);

            // 토핑 가짓수가 같다면
            if (map.size() == personMap.size()) result++;
        }
        
        return result;
    }
}