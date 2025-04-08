package LineUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AgeArray_10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Member> list = new ArrayList<>();


		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Member(i,Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(list);

		for(int i=0;i<n;i++) {
			bw.write(list.get(i).toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

class Member implements Comparable<Member>{

	int idx, age;
	String name;

	public Member(int idx,int age,String name) {
		this.idx=idx;
		this.age=age;
		this.name=name;
	}

	public int compareTo(Member o) {
		if(this.age!=o.age)
			return this.age-o.age;
		else
			return this.idx-o.idx;
	}

	public String toString() {
		return age+" "+name +"\n";
	}


}












