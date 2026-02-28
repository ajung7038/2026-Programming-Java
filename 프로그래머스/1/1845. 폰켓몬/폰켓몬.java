import java.util.Set;
import java.util.HashSet;
import java.lang.Math;

class Solution {
    public int solution(int[] nums) {
        // N/2마리를 가져갈 수 있음
        // 몇 종류가 있는지 확인
            // 만약 N/2보다 종류가 적다면 그만큼의 종류를 가져갈 수 있음
            // 만약 종류 수보다 N/2가 적다면 N/2만큼의 종류를 가져갈 수 있음
        // 따라서, 종류와 가져갈 수 있는 개수의 최솟값을 리턴하면 됨.
        // 종류당 몇 마리는 중요하지 않기 때문에 Set을 통해 중복 값 제거
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), nums.length/2);
    }
}