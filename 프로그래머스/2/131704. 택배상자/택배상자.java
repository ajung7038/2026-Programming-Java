import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        
        int i = 1; // 현재 상자 인덱스
        int orderIdx = 0;
        while (i < order.length+1 || orderIdx < order.length) {
            // 현재 실어야 할 상자가 몇 번 상자인지 나타내는 변수
            int boxIdx = order[orderIdx];
            
            if (boxIdx == i) {
                result++;
                i++;
                orderIdx++;
            } else if (boxIdx > i) {
                stack.push(i++);
            } else {
                if (stack.pop() == boxIdx) {
                    result++;
                    orderIdx++;
                } else return result;
            }
        }
        
        return result;
    }
}