package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {
	//준내 어렵다
	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		dfs(0);
		System.out.println(sb);
	}
	static void dfs(int depth) {
		if(depth == m) { //depth와 m이 같아질 시 내용을 출력
			for(int a : arr) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		//3 2를 예로
		//처음 1를 arr[0]에 저장 이후 depth+1호출. 1자리(i=0)는 방문(true)했으니 넘기고
		//i=1에서 2를 arr[1]에 저장 이후 +1재귀호출. m과 depth가 같으니 sb에 저장
		//이후 리턴을 통해 재귀에서 돌아오면 i=1상태로 돌아옴. depth는 다시 1.
		//이후 visit[1]은 다시 false. i는 2가 되고 arr[1]에 3을 넣음.
		//그럼 다시 sb에 저장하고 i=0일때로 돌아옴
		//이후 i=1이 되고 다시 반복
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=i+1;
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}
