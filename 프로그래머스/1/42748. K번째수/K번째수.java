import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // commands 돌면서 i, j, k 확인
        // array 복사, 자르기, 정렬, k번째 수 리턴
        int tcSize = commands.length;
        int[] result = new int[tcSize];
        int rsltPointer = 0;
        
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            // i~j까지 arr 복사
            int arrSize = j-i+1;
            int[] newArr = new int[arrSize];
            newArr = copyArr(array, newArr, arrSize, i-1, j-1);
            // 정렬
            Arrays.sort(newArr);
            // k값 찾기
            result[rsltPointer++] = newArr[k-1];
        }
        
        return result;
    }
    
    public static int[] copyArr(int[] arr, int[] newArr, int arrSize, int start, int end) {
        for (int i=0; i<arrSize; i++) {
            newArr[i] = arr[start+i];
        }
        return newArr;
    }
}