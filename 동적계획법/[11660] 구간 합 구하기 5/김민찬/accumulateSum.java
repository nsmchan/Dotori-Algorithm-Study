
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class accumulateSum{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());           //n
        int testCase = Integer.parseInt(st.nextToken());    //t

       

        long[][] oriArr = new long[n][n];      //n*n 원본배열만들기
        for(int i=0;i<n;i++){               // 원본배열 만들기
                st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                oriArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //합배열+1 만들기  --> 0배열 만들어서 if 문 넘어가기
        //끝값
        //
        long[][] sumArr = new long[n+1][n+1];

        for(int i=0; i<=n;i++){
            sumArr[0][i]=0;
            sumArr[i][0]=0;
        }

        for(int i=1;i<=n;i++){              
            for(int j=1;j<=i;j++){
                sumArr[1][i] += oriArr[0][j-1];   
            }
        }
        for(int i=1;i<=n;i++){             
            for(int j=1;j<=i;j++){
                sumArr[i][1] += oriArr[j-1][0];   
            }
        }
        // 한번 더 더하게됨
        sumArr[1][1]/=2;
        //...
        for(int i=2;i<=n;i++){             
            for(int j=2;j<=n;j++){
                sumArr[i][j] = oriArr[i-1][j-1]+ sumArr[i-1][j]+sumArr[i][j-1]-sumArr[i-1][j-1]; 
            }
        }

        for(int t=0;t<testCase;t++){    //test만큼 돌기
                                        // 

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

         bw.write(sumArr[x2][y2]-sumArr[x1-1][y2]-sumArr[x2][y1-1]+sumArr[x1-1][y1-1]+"\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }
}