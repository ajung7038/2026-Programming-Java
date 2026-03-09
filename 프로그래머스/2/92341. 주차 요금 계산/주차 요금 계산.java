import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량 입차/출차 시간이 주어지고, fees에 따라 차량 번호가 작은 순서부터 요금을 계산하는 문제
        // 같은 차량끼리는 묶어서 돈 계산
        
        // map : <차량 번호, 총시각>
        Map<String, Integer> map = new HashMap<>();
        // inputMap : <차량 번호, 시작시간>
        Map<String, Integer> inputMap = new HashMap<>();
        
        // 1. 입/출차 기록을 돌기
        for (String record : records) {
            // 입차 : inputMap.put()
            String[] recordList = record.split(" ");
            
            // 분 단위로 시간 표현 (input - 00:00 형태의 시간)
            int time = changeHourToMin(recordList[0]);
            
            String carNum = recordList[1];
            
            if (recordList[2].equals("IN")) {
                inputMap.put(carNum, time);
            } else { // 출차 : inputMap.get()
                // 시각 비교, 차이만큼 map에 넣기
                int startTime = inputMap.get(carNum);
                map.put(carNum, map.getOrDefault(carNum, 0) + time - startTime);
                // inputMap.get()을 -1으로 초기화
                inputMap.put(carNum, -1);
            }
        }
            
        // 2. 마지막에 출차 검사
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            // 만약 inputMap의 값이 0이 아니라면 (입차만 했다면)
            int startTime = entry.getValue();
            if (startTime != -1) {
                // 23:59까지 시각 비교, 차이만큼 map에 넣기
                int time = changeHourToMin("23:59");
                String carNum = entry.getKey();
                map.put(carNum, map.getOrDefault(carNum, 0) + time - startTime);
                // inputMap.get()을 0으로 초기화
                inputMap.put(carNum, 0);
            }
        }
        
        // 3. map.keySet()을 차량번호로 정렬 (int로 변환)
        List<String> lst = new ArrayList<>(map.keySet());
        lst.sort((o1, o2) -> { // 오름차순 정렬
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        }); 
        
        List<Integer> result = new ArrayList<>();
        for (String carNum : lst) {
            int time = map.get(carNum);
            // fees와 비교하여 기본 시간 이하라면 기본 요금
            if (time <= fees[0]) result.add(fees[1]);
            // 넘는다면 [ (현재시간 - 기본시간)/단위시간 ](올림) *단위요금 + 기본요금
            else {
                int feeUnit = (time-fees[0]);
                int fee = 0;
                if (feeUnit % fees[2] != 0) fee = feeUnit/fees[2]+1;
                else fee = feeUnit/fees[2];
            
                result.add(fees[1] + fee*fees[3]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int changeHourToMin(String time) {
        String[] timeByString = time.split(":");
        return Integer.parseInt(timeByString[0])*60 + Integer.parseInt(timeByString[1]);
    }
}