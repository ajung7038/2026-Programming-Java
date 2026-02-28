import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        // N마리 중 N/2마리 가져갈 수 있다.
        // 같은 종류의 폰켓몬은 같은 번호 소유
        // 조합
        // 최대한 많은 종류의 폰켓몬을 가지고 싶어 함. -> 몇 종류인지 return
        
        // 같은 종류 합치기 -> map
        // 종류, 마릿수 비교 -> 더 큰 값 리턴
        
        // <종류, 개수>
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int type : nums) {
            mp.put(type, mp.getOrDefault(type, 0) +1);
        }
        
        int typeSize = mp.size(); // 종류
        int num = nums.length/2;
        
        return typeSize < num ? typeSize : num;
    }
}