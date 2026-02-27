import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int count=0;
            int[] sortedArr = new int[20];
            for (int j=0; j<20; j++) {
                // 버블 정렬
                int num = Integer.parseInt(st.nextToken());
                count += insertSort(sortedArr, num, j);
            }
            
            sb.append(tc).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static int insertSort(int[] sortedArr, int num, int index) {
    	int count=0;
    	int j = index - 1;
    	while (j>=0 && num < sortedArr[j]) {
    		sortedArr[j+1] = sortedArr[j];
    		j--;
    		count++;
    	}
    	sortedArr[j+1] = num;
        return count;
    }
}