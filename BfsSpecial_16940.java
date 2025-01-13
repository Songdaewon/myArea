package part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsSpecial_16940 {
	static int n, index;
	static boolean visit[];
	static int myAnswer[];
	static Queue<Integer> q = new LinkedList<Integer>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		myAnswer = new int[n];
		
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//1 2일시 1번 리스트에 2번을 넣고, 2번 리스트에 1번을 넣음
			list.get(from).add(to);
			list.get(to).add(from);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			myAnswer[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean check = Bfs();
		
		if(myAnswer[0]!=1) check=false;
		if(check)
			System.out.println(1);
		else System.out.println(0);
	}
	
	static boolean Bfs() {

		visit[1]=true;
		q.add(1);
		index=1;
		
		while(!q.isEmpty()) {
			int start = q.poll();
			int count=0;
			for(int i:list.get(start)) {
				if(!visit[i]) {
					visit[i]=true;
					count++;
				}
			}
			
			for(int i=index;i<index+count;i++) {
				if(!visit[myAnswer[i]]) {
					return false;
				}
				else {
					q.add(myAnswer[i]);
				}
			}
			index+=count;
		}
		return true;
	}
	
}






