import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class main {
    static int N;// 나무의 수
    static int M;// 필요한 나무의 길이
    static int lengths[]; //각각 나무의 길이
    public static void main(String[]args)throws Exception{
     
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); // M 필요한 개수

        lengths=new int[N];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lengths[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lengths);   // 정렬

        long result=0;
        long end=lengths[N-1];
        long start=0;
        long mid;
        long sum;
        while(true){  // start>end를 넣어도 상관 없다 but 돌기전 조건 검증
            mid= (start+end)/2;
            sum=0;
        for (int i : lengths) {
            if(i>mid){
               sum+=(i-mid);

            }
        }
        // sum==M일 때가 최소(result 값)    
        if(sum==M){
            result=mid;
            break;
        }
        // 부족하므로 end 범위 감소 
        //ex) mid 15: 1-30 -> mid 7: 1-14
        else if(sum<M){
             end=mid-1;  
        }
        // 많으므로 start 증가 but 이것이 최소값이 될수 있으니 result에 mid 미리 저장 
        else{
            result=mid;
            start=mid+1;
        }
        if(start>end){    // while 문 돈후에 조건 검증
            break;

        }

     }
       System.out.println(result);
    }

}
