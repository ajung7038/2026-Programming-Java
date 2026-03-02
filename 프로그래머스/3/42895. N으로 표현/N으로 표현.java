import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        // dp[N을 사용한 횟수] : 가질 수 있는 num을 Set으로 관리
        Set<Integer>[] dp = new Set[9];
        
        // N == number인 경우
        dp[1] = new HashSet<>();
        dp[1].add(N);
        if (N == number) return 1;
        
        // i: N을 사용한 횟수, i만큼 반복 수행
        for (int i=2; i<9; i++) {
            dp[i] = new HashSet<>();
            // N을 붙여서 만들 수 있는 수를 set에 추가
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<i; j++) {
                sb.append(N);
            }
            dp[i].add(Integer.parseInt(sb.toString()));
            
            int j=1;
            int k = i-j;
            for (int l=0; l<i/2; l++) {
                // set이므로 j를 (i/2)만큼 수행
                if (j>k) break;
                
                for (int num1 : dp[j]) {
                    for (int num2 : dp[k]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num2 - num1);
                        dp[i].add(num1 * num2);
                        if (num1 !=0 && num2 != 0) {
                            dp[i].add(num1 / num2);
                            dp[i].add(num2 / num1);
                        }
                    }
                }
                j++;
                k--;
            }
            
            for (int testNum : dp[i]) {
                System.out.println(testNum);
            }
            
            // set 내 number이 있다면 return
            if (dp[i].contains(number)) return i;
        }
            
            
        return -1;
    }
}