package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewelThief_1202 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Jewel[] jew = new Jewel[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			jew[i] = new Jewel(m, v);
		}

		//보석의 무게를 오름차로, 무게가 같을 경우 가격을 내림차로 설정
		Arrays.sort(jew, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1,Jewel o2) {
				if(o1.m==o2.m) {
					return o2.v-o1.v;
				}
				return o1.m-o2.m;
			}
		});
		
		int bag[] = new int[k];
		for(int i=0;i<k;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		//가방 크기 오름차순
		Arrays.sort(bag);
		
		long max=0;
		
		//높은 가격이 먼저 나옴
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		//가방 무게가 작은 순부터 탐색
		for(int i=0,j=0;i<k;i++) {
			while(j<n) {
				//해당 가방에 보석을 넣을 수 없다면
				if(bag[i]<jew[j].m) {
					break;
				}
				//가방에 담을 수 있는 무게의 보석의 가치를 큐에 삽입
				pq.add(jew[j++].v);
			}
			
			//그중 가장 가격이 높은 것이 나옴
			if(!pq.isEmpty()) {
				max+=pq.poll();
			}
			
		}
		System.out.println(max);
	}

	static class Jewel {
		int m; // 무게
		int v; // 가격

		Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
