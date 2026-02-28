import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 완주하지 못한 선수 한 명을 리턴하는 문제
        // edge case : 경기에 참여한 선수가 1명일 경우 -> 아무도 완주하지 못함.
            // 즉, completion이 빈 배열일 수도 있음
        
        // 푸는 방법
        // 1. 정렬
        // 2. 한 명씩 비교하며 있는지 없는지 검사
        
        // 완주한 사람이 없다면
        if (completion.length < 1) {
            return participant[0];
        }
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}