import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.add(Long.parseLong(st.nextToken()));
            }
        }
        for (int i=0; i<n-1; i++) {
            pq.poll();
        }
		System.out.println(pq.poll());
	}
}