import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class VirusBfs_2606 {
	static boolean visit[];
	static int arr[][];
	static int com, n;
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		com = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		arr = new int[com+1][com+1];
		visit = new boolean[com+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from][to]=arr[to][from]=1;
		}
		bfs();
		System.out.println(count-1);
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int v;
		
		while(!q.isEmpty()) {
			v = q.poll();
			
			for(int i=0;i<=com;i++) {
				if(arr[v][i]==1&&!visit[i]) {
					visit[i]=true;
					q.add(i);
					count++;
				}
			}
		}
		
	}
}




