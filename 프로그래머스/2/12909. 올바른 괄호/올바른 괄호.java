import java.util.Stack;

class Solution {
    boolean solution(String s) {
        // 10만 이하의 자연수이므로 대략적으로 O(nlogn)으로 구현 필요
        // 열린 괄호를 스택에 넣기
        // 닫힌 괄호는 pop()
        // 만약 열린 괄호가 없는데 닫힌 괄호가 나온다면 false
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}