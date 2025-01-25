package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class HideAndSeek4_13913 {
	static int n,k;
	static int check[] = new int[100001];
	static int[] parent = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());


		bfs(n);

		Stack<Integer> stack = new Stack<>();
		stack.push(k);
		int index = k;

		while (index != n) {
			stack.push(parent[index]);
			index = parent[index];
		}

		// 최종 출력
		sb.append(check[k] - 1 + "\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb.toString());
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		check[num]=1;

		while(!q.isEmpty()) {
			int temp = q.poll();

			if(temp==k)
				return;
			//앞과 뒤 그리고 *2를 하는 경우의 수
			for(int i=0;i<3;i++) {
				int next;

				if(i==0) 
					next=temp+1;
				else if(i==1)
					next=temp-1;
				else 
					next=temp*2;

				//경우의 수가 문제 없이 성립이 될때마다 queue에 삽입
				if(next>=0&&next<check.length&&check[next]==0) {
					q.add(next);
					check[next]=check[temp]+1;
					parent[next] = temp;
				}
			}
		}
	}
}





