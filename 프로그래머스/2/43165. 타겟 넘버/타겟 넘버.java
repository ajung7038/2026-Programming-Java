class Solution {
    public static int count = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, numbers, target, 1);
        dfs(0, numbers, target, 0);
        
        return count;
    }
    
    public static void dfs(int depth, int[] numbers, int target, int symbol) {    
        int num = numbers[depth];
        int newTargetNum = 0;
        newTargetNum = symbol == 1 ? target-num : target+num;
        
        // 종료 조건
        if (depth == numbers.length-1) {
            if (newTargetNum == 0) {
                count++;
            }
            return;
        }
        
        dfs(depth+1, numbers, newTargetNum, 1);
        dfs(depth+1, numbers, newTargetNum, 0);
    }
}