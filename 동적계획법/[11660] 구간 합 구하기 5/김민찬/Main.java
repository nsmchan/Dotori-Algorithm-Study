import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

    static int N;
    static int M;
    static int dp[][];

    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        dp=new int[N+1][N+1];
        for (int i = 1; i <=N; i++) {   // dp 배열 저장
            int sum=0;
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                sum += Integer.parseInt(st.nextToken());
                dp[i][j]=dp[i-1][j]+sum;
            }

        }
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<M;k++){

            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            int answer=dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }



}