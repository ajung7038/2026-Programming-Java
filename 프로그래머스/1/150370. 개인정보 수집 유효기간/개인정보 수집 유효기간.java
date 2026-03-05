import java.util.StringTokenizer;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. today 날짜 파싱
        String[] dayList = today.split("\\.");
        int year = Integer.parseInt(dayList[0]);
        int month = Integer.parseInt(dayList[1]);
        int day = Integer.parseInt(dayList[2]);
        // day 단위로 변환
        day += year * 28 * 12 + month * 28;
        
        // 2. terms를 map으로 관리 (파싱)
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            // day 단위로 저장
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        // 결과용 리스트
        List<Integer> result = new ArrayList<>();
        
        // 3. privacies를 돌면서
        int idx = 1;
        for (String privacy : privacies) {
            // 약관 종류 확인
            StringTokenizer st = new StringTokenizer(privacy);
            String privacyDate = st.nextToken();
            String privacyType = st.nextToken();
            
            
            int type = map.get(privacyType);
            // 약관 날짜 지났는지 확인 -> 지났다면 result에 추가 (List로 관리)
            String[] privacyDateArray = privacyDate.split("\\.");
            int privacyYear = Integer.parseInt(privacyDateArray[0]);
            int privacyMonth = Integer.parseInt(privacyDateArray[1]);
            int privacyDay = Integer.parseInt(privacyDateArray[2]);
            privacyDay += privacyYear * 28 * 12 + privacyMonth * 28;
            
            if (day > privacyDay+type-1) result.add(idx);
            idx++;
        }
                
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}