import java.util.PriorityQueue;
import java.util.StringTokenizer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                Long num = Long.parseLong(st.nextToken());
                if (pq.size() <n || pq.peek() < num) {
                	pq.add(num);
                }
                if (pq.size() > n) {
                    pq.poll();
                }
            }
        }
		System.out.println(pq.poll());
	}
}