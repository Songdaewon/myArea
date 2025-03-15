package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lecture_2109 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		//강의료를 내림차로, 강의료가 같다면 강의일정을 오름차로 우선순위 지정
		PriorityQueue<Req> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1.p == o2.p) return o1.d - o2.d;
			return o2.p - o1.p;
		});
		
		//초기화 및 큐 삽입
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.add(new Req(p,d));
		}
		
		int maxP=0;
		boolean scheduled[] = new boolean[10001];
		while(!pq.isEmpty()) {
			
			Req cur = pq.poll();
			
			//pq에서 제일 먼저 나오는 건 강의료가 가장 비싼 것이다.
			//날짜를 기준으로 1부터 d까지가 아닌
			//그냥 가장 비싼 강의부터 순서대로 스케줄을 짜면 가장 큰 이익을 벌 수 있다.
			for(int i=cur.d;i>0;i--) {
				if(!scheduled[i]) {
					scheduled[i] = true;
					maxP += cur.p;
					break;
				}
			}
		}
		System.out.println(maxP);
	}
	static class Req
	{
		int p,d;

		public Req(int p, int d) {
			this.p = p;
			this.d = d;
		}
	}
}
