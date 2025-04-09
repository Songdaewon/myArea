package DivideandConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LangueEngMath {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		ArrayList<grade> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			list.add(new grade(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
		for(int i=0;i<n;i++) {
			bw.write(list.get(i).toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
class grade implements Comparable<grade>{
	int langu, eng, math;
	String name;

	public grade(String n,int l,int e,int m) {
		this.langu=l;
		this.eng=e;
		this.math=m;
		this.name=n;
	}

	
	public int compareTo(grade o) {
		if(this.langu==o.langu) {
			if(this.eng==o.eng){
				if(this.math==o.math) {
					return this.name.compareTo(o.name);
				}
				else
					return o.math-this.math;
			}
			else {
				return this.eng-o.eng;
			}
		}
		
		return o.langu-this.langu;
	}
	
	public String toString() {
		return name+"\n";
		
	}
}