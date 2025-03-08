package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class FourOperation_14395 {
	static long s,t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Long.parseLong(st.nextToken());
		t = Long.parseLong(st.nextToken());

		if(s==t) {
			System.out.println(0);
			return;
		}

		Set<Long> set = new HashSet<>();
		Queue<Num> q = new LinkedList<>();

		String order[] = {"*","+","-","/"};
		q.add(new Num(s,""));
		set.add(s);

		while(!q.isEmpty()) {
			Num n = q.poll();

			if(n.n==t) {
				System.out.println(n.opers);
				return;
			}

			long next=n.n;
			for(int i=0;i<4;i++) {
				switch(i) {
				case 0:
					next = n.n*n.n;
					break;
				case 1:
					next = n.n+n.n;
					break;
				case 2:
					next = n.n-n.n;
					break;
				case 3:
					if(n.n!=0)
						next = n.n/n.n;
					break;
				}
				if(!set.contains(next)) {
					set.add(next);
					q.add(new Num(next,n.opers+order[i]));
				}
			}
		}

		System.out.println(-1);

	}
	static class Num{
		long n;
		String opers="";

		public Num(long s,String opers) {
			this.n=s;
			this.opers=opers;
		}
	}
}
