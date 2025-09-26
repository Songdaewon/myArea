package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.StringTokenizer;

public class Guitar_2343 {
    static int lecture[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        lecture=new int[n];
        st=new StringTokenizer(br.readLine());

        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            lecture[i]=Integer.parseInt(st.nextToken());
            if(lecture[i]>max){
                max=lecture[i];
            }
            sum+=lecture[i];
        }

        System.out.println(BinarySearch(max,sum,m));





    }
    public static int BinarySearch(int left,int right,int M){
        while(left<right){
            int mid = (left+right)/2;
            if(getCount(mid)>M){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    static int getCount(int mid){
        int count=1;
        int remain=mid;

        for(int i=0;i<n;i++){
            if(remain<lecture[i]){
                remain=mid;
                count++;
            }
            remain-=lecture[i];
        }
        return count;
    }
}
