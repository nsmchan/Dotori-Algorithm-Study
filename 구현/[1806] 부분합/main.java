import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;// 수열 요소 개수
    static int S; // 목표 합
    static int[] nums;
    static int low,high;
    static int sum,min,answer;
    public static void main(String[] args) throws Exception {
     //알고리즘 문제 풀때는 exception을 하면 거의 모든 오류 던져줌
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1]; // out of index 방지 N+1

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

        }
        low=0;high=0;sum=nums[0];min=0; answer=N+1;
         //sliding window - low,high 설정 high값이 N이 되면 전부 탐색이 끝난것
        //low 값이 있어야 초기 이전값을 순차적으로 제거하면서 오게 된다.
        while(true){
            //sum>=S 일때 low++
            if(sum>=S){
                min=high-low+1;
                if(min<answer){
                    answer=min;
                }
                sum-=nums[low++];
            }
            //sum<S일때 ++high
            else{
                sum+= nums[++high];
            }
             // 탈출 조건
            if(high==N){
                break;
            }
        }if(answer==(N+1)){  // 합을 만드는게 불가능할시 0 출력 
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }
}