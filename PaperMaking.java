package DivideandConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperMaking {
	
	static int n;
	static int[][] paper;
	
	static int blue=0;
	static int white=0;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		paper[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        cut(0,0,n);
        
        System.out.println(white);
        System.out.println(blue);
	}

	private static void cut(int x, int y, int size) {
		//모두 같은 색이라면
		if(check(x,y,size)) {
			if(paper[x][y]==1) {
				blue++;
			}
			else {
				white++;
			}
			
			return;
		}
		
		int newSize=size/2;
		/*
		cut(x, y, newSize);        			    //1사분면
		cut(x, y+newSize, newSize); 			//2사분면
		cut(x+newSize ,y, newSize); 			//3사분면
		cut(x+newSize ,y+newSize, newSize);		//4사분면           
		*/
		
		for(int i=0;i<size;i+=newSize) {
			for(int j=0;j<size;j+=newSize) {
				cut(x+i,y+j,newSize);
			}
		}
		
	}
	private static boolean check(int x, int y, int size) {
		
		int init = paper[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]!=init)
					return false;
			}
		}
		
		return true;
	}
}
