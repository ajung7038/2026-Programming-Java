import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // input : 진도, 작업률
        // 차례대로 작업 완료 가능, 앞보다 먼저 끝내더라도 기다려야 한다
        // output : 각 배포마다 몇 개의 기능이 배포되는지 return
        
        // 1. 각 작업간 진도, 작업률을 확인하여 며칠만에 끝나는지 확인
            // progresses, speeds를 돌면서
            // int dueDay = (100-progress)/speeds
            // if ((100-progress)%speeds != 0) dueDay++; 
        // 2. 끝나는 날짜가 같은 작업 간 count, 추가 후 리턴
        // ex, 7 3 9 => 7 7 9로
            // for문 돌면서 현재 비교 대상인 숫자보다 다음 숫자가 작거나 같으면 +1
                // 그렇지 않으면 현재 비교 대상 숫자 업데이트, 기존 count 숫자 넣기
        // 마지막에 for문 돌던 count 값 리스트에 추가
        
        // 뒤에서 넣고 앞에서 뺌 -> 큐
        // edge case : progresses가 하나인 경우
        
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int dueDay = 100 - progresses[i];
            int releaseDay = dueDay/speeds[i];
            if ((dueDay%speeds[i]) != 0) {
                releaseDay++;
            }
            q.add(releaseDay);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int count = 1;
        int vsNum = q.poll();
        for (int num : q) {
            if (vsNum >= num) count++;
            else {
                vsNum = num;
                result.add(count);
                count = 1; // count 초기화
            }
        }
        
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}