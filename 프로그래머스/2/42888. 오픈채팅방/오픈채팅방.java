import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        // 0. Map<userId, name> 생성
        Map<String, String> userMap = new HashMap<>();
        List<String> behaviorList = new ArrayList<>();
        
        // 1. record 돌기
        for (String r : record) {
            String[] splitRecord = r.split(" ");

            String behavior = splitRecord[0];
            String username = splitRecord[1];
            
            if (behavior.equals("Leave")) {
                behaviorList.add(r);
                continue;
            }
            
            String nickname = splitRecord[2];
            
            if (behavior.equals("Enter")) behaviorList.add(r);
            userMap.put(username, nickname); // Change
            
        }
        
        // 2. 출력 (behaviorList 돌기)
        String[] result = new String[behaviorList.size()];
        int idx = 0;
        for (String r : behaviorList) {
            String[] splitRecord = r.split(" ");
            String behavior = splitRecord[0];
            String username = splitRecord[1];
            String nickname = userMap.get(username);
            
            // ENTER : map.get(uid)님이 들어왔습니다.
            if (behavior.equals("Enter")) result[idx++] = nickname + "님이 들어왔습니다.";
            
            // LEAVE : map.get(uid)님이 나갔습니다.
            else result[idx++] = nickname + "님이 나갔습니다.";
        }
        
        return result;
    }
}