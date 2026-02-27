import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            // 0 0 0 나올 때까지
            String str = br.readLine();
            if (str.equals("0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            // 세 변 입력 받기
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (!isTriangle(a, b, c)) {
                sb.append("Invalid").append("\n");
            } else if (a == b || b == c || c == a) {
                if (a == b && b == c) {
                    sb.append("Equilateral").append("\n");
                } else sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        
        System.out.println(sb);
    }

    public static boolean isTriangle(int a, int b, int c) {
        // 크기 비교
        // 가장 긴 변의 길이보다 나머지 두 변 길이의 합이 길지 않으면 false
        if (a > b && a > c) {
            return a < b + c;
        } else if (b > a && b> c) {
            return b < a + c;
        } else return c < a + b;
    }
}