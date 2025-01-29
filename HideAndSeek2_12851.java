package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek2_12851 {
	static int n, k, fastest=Integer.MAX_VALUE;;
	static int check[] = new int[100001];
	static int method = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(fastest);
		System.out.println(method);
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n]=1;

		while(!q.isEmpty()) {
			int temp = q.poll();
			
			//동생 발견
			if(temp==k) {
				//새로운 최단 거리가 갱신되면 기존의 최단거리는 방법에서 제외됨
				//그러니 방법을 1부터 다시 시작
				if(check[temp]-1<fastest) {
					fastest = check[temp]-1;
					method=1;
				}
				//기존 기록과 똑같다면 새로운 방법 추가
				else if(check[temp]-1==fastest) {
					method++;
				}
			}

			for(int i=0;i<3;i++) {
				int next;

				if(i==0) {
					next = temp+1;
				}
				else if(i==1) {
					next = temp-1;
				}
				else {
					next = temp*2;
				}

				if(next>=0&&next<check.length) {
					//첫 방문과 같은 최단 기록
					if(check[next] == 0 || check[next] == check[temp] + 1) {
						q.add(next);
						check[next]=check[temp]+1;
					}
				}
			}
		}
	}
}









