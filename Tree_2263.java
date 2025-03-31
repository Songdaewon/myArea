package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//포스트 오더에선 맨 마지막이 루트노드이다.
//인 오더에선 찾은 루트 노드를 기점으로 왼쪽과 오른쪽 자식 노드들을 나눌 수 있다.
//또 포스트 오더를 나누어 가운뎃 값(미니 루트)를 찾아서 기점을 나눈다.

public class Tree_2263 {
	
	static StringBuilder sb = new StringBuilder();
	static int in[];
	static int inIdx[];
	static int post[];
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		in = new int[n];
		inIdx = new int[n+1];
		post = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			inIdx[in[i]]=i;
		}
		
		getPre(0,n-1,0,n-1);
		System.out.println(sb);
	}

	private static void getPre(int inS, int inE, int pS, int pE) {
		if(inS>inE||pS>pE)
			return;
		
		//루트는 포스트의 마지막
		int root = post[pE];			
		sb.append(root+" ");
		
		int rootIdx = inIdx[root];		//in을 이용하여 루트(가운데)의 인덱스 뽑기
		int leftNodeL = rootIdx-inS;	//루트를 기준으로 구한 왼쪽 노드들의 길이
		
		//루트 기준 왼쪽 탐색
		getPre(inS, rootIdx-1, pS, pS+leftNodeL-1);
		
		//루트 기준 오른쪽 탐색
		getPre(rootIdx+1, inE, pS+leftNodeL, pE-1); //인덱스-1을 하여 post에서 루트룰 하나씩 찾는다.
	}

}









