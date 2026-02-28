import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        // 접두어가 있으면 false, 아니면 true
        // 중복해서 전화번호가 들어있지는 않음 -> Map 활용
        // 한 전화번호 전체가 다른 전화번호의 앞에 있어야 함
        
        // 잘 몰라서 containsKey() 찾아봄
        // Map -> Set으로 변경
        // 계속 끝까지 검사 안 하고 틀림.
        // 문제 이해 잘 못함.. -> 조급해서 바로 구현하려고 했었던 듯..
        
        // 제일 짧은 전화번호의 길이 저장, 모든 Set 돌면서 딱 그 길이만큼 검사
            // 근데 만약에 12, 345, 3456 이렇게 되면 예외니까 아니라고 판단.
        
        // phone_book의 길이가 100만이니까 O(nlogn) 정도는 나와야 한다고 생각했음
            // 단순 반복문으로는 한계가 있다고 판단
        
        // 1. 맨 앞부분만 Map 형태로 저장
        // 2. 맨 앞 숫자가 같은 .. 그런데 Map 형태로 저장하면 key가 겹칠 수 없음
        
        // indexOf를 활용 (포함되어 있어야 하는데? 하다가 검색)
        
        // HashSet에 넣기 전 indexOf로 검사 -> 있으면 false
        // HashSet 쓴 이유는 찾을 때 O(1)만큼 빠르게 찾을 수 있기 때문
        // 그 많은 것들 중 어떻게 하나씩 찾지? O(n)만큼 들 텐데..
        // 순서 반대로 되면? indexOf가 소용 없는 거 아닌가..
        
        // 폰 번호가 짧은 길이 순서대로 정렬 -> 돌면서.. 근데 그러면 O(n^2 나올 것 같아서..)
        
        
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : set) {
            int len = phone.length();
            for (int i=0; i<len-1; i++) {
                if (set.contains(phone.substring(0, i+1))) {
                    return false;
                }
            }
        }
        return true;
    }
}