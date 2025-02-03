package part6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class TreeHL {

	static class Node{
		int value;
		Node left;
		Node right;
		int level;
		int row;

		public Node(int value) {
			this.value = value;
		}
	}

	static int n;
	static int row=1;
	static int maxLevel=-100;
	static int[] minR, maxR;
	static Node[] node;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		node = new Node[n+1];
		minR = new int[n+1];
		maxR = new int[n+1];

		for (int i = 1; i <= n; i++)
			node[i] = new Node(i);

		boolean[] ischild = new boolean[n + 1];

		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			if(left!=-1) {
				node[root].left=node[left];
				ischild[left]=true;
			}
			if(right!=-1) {
				node[root].right=node[right];
				ischild[right]=true;
			}
		}

		setLevel(node[1],1);
		setRow(node[1]);
		//minR 배열을 최대값으로 초기화
		Arrays.fill(minR, Integer.MAX_VALUE);
		
		int maxWidth = 0, bestLevel = 0;
		for (int i = 1; i <= maxLevel; i++) {
			int width = maxR[i] - minR[i] + 1;
			if (width > maxWidth) {
				maxWidth = width;
				bestLevel = i;
			}
		}

		System.out.println(bestLevel + " " + maxWidth);
	}
	static void setLevel(Node n,int level) {
		if(n==null)
			return;
		
		n.level=level;

		//가장 큰 레벨 저장
		maxLevel = Math.max(maxLevel, level);

		setLevel(n.left,level+1);
		setLevel(n.right,level+1);


	}
	private static void setRow(Node n) {
		if (n == null) 
			return;

		setRow(n.left); // 왼쪽 노드 탐색
		n.row=row++;
		minR[n.level] = Math.min(minR[n.level], n.row);
		maxR[n.level] = Math.max(maxR[n.level], n.row);
		setRow(n.right); // 오른쪽 노드 탐색
	}

}






