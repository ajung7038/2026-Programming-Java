import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int result = 0;
        
        for (int x=0; x<len; x++) {
            boolean flag = true;
            for (int i=0; i<len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    
                    char vsC = stack.pop();
                    if (c == ')' && vsC == '(') continue;
                    else if (c == ']' && vsC == '[') continue;
                    else if (c == '}' && vsC == '{') continue;
                    else flag = false; break;
                    
                }
            }
            if (flag && stack.isEmpty()) result++;
            // s 회전
            String first = s.substring(0, 1);
            String last = s.substring(1, len);
            s = last+first;
        }
        
        return result;
    }
}