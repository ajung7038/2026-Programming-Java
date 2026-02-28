import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mp = new HashMap<>();
        
        for (String name : participant) {
            mp.put(name, mp.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            mp.put(name, mp.get(name)-1);
        }
        
        String returnName="";
        for (String name : mp.keySet()) {
            if (mp.get(name) != 0) {
                returnName = name;
                break;
            }
        }
        
        return returnName;
        
        
    }
}