import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

     static int N;
     static int M[];  // 배열

     static int LtoR[];
     static int RtoL[];
     
    public static void main(String[]args)throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {          //배열 저장

            M[i]=Integer.parseInt(st.nextToken());

        }
        LtoR=new int[N];
        RtoL=new int[N];
        // 왼쪽 부터 gcd누적합 구하기
        LtoR[0]=M[0]; // 첫 자리는 최대 공약수 자기자신
        for (int i = 1; i <N; i++) {
            LtoR[i]=gcd(LtoR[i-1],M[i]);
        }
        // 오른쪽 끝부터 gcd누적합 구하기
        RtoL[N-1]=M[N-1];
        for (int i =N-2; i>=0 ;i--) {
            RtoL[i]=gcd(RtoL[i+1],M[i]);
        }

        int max=0;
        int K=0;
        int gcd=0;
        //i 값기준 LtoR(0 ~ i-1) RtoL(i+1 ~N-1)
        for (int i = 0; i < N-1; i++) {

            if(i==0){
                gcd=RtoL[1];
            }
            else if(i==N-1){
                gcd=LtoR[N-2];
            }
            else {
                gcd = gcd(LtoR[i - 1], RtoL[i + 1]);
            }
            // K % gcd==0
            if(max<gcd && M[i]%gcd!=0){
                max=gcd;
                K=M[i]; //뺀수
            }
        }
        if (max==0){    // 최대공약수 x
            System.out.println(-1);
        }
        System.out.println(max+" "+K);

    }
     // 유클리드 호제법 정의 gcd(a,b)==gcd(b,r)==gcd(b,a%b),Stop when a%b==0
    static int gcd(int a,int b){   //재귀를 써도 되는데 확장 유클리드호제법을 할꺼면 엄청 복잡, 왠만하면 while문
      int r;
        while(b!=0){

            r = a%b;
            a =b;
            b = r;
        }
        return  a;
    }
}

