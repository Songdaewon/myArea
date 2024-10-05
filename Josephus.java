package a;
import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Josephus {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while (q.size()>1) {
			
			for(int i=0;i<k-1;i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		
		bw.write(sb.toString()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
