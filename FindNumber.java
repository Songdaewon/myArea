import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arrN[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN); //이분탐색을 위한 정렬

        int M = Integer.parseInt(br.readLine());
        int arrM[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        boolean isFind = false; //M의 요소가 N에 존재하는지 확인하는 bool
        int idxM = 0; //M의 인덱스
        int target;   //검색할 요소

        while(idxM<M){
            target = arrM[idxM];

            int left = 0;   //N의 왼 인덱스
            int right = N-1;//오른 인덱스

            while(left<=right){  //이분탐색 시작
                int mid = (left+right)/2;

                if(target==arrN[mid]){  //찾았으면 중단
                    isFind = true;
                    break;
                }
                else if(target<arrN[mid]){ //왼편에 있다면
                    right = mid-1;
                }
                else if(target>arrN[mid]){ //오른편에 있다면
                    left = mid+1;
                }
            }

            //이분탐색이 끝난 후.
            if(isFind){ //찾았다면 1
                sb.append(1+"\n");
                isFind = false;
            }
            else{       //실패시 0
                sb.append(0+"\n");
            }

            ++idxM; //다음 M 탐색
        }

        System.out.println(sb);
    }
}
