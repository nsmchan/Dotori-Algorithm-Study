
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

        //합배열 만들기
        //끝값
    
        long[][] sumArr = new long[n][n];
        for(int i=0;i<n;i++){              
            for(int j=0;j<=i;j++){
                sumArr[0][i] += oriArr[0][j];   
            }
        }
        for(int i=0;i<n;i++){             
            for(int j=0;j<=i;j++){
                sumArr[i][0] += oriArr[j][0];   
            }
        }
        // 한번 더 더하게됨
        sumArr[0][0]--;
        //...
        for(int i=1;i<n;i++){             
            for(int j=1;j<n;j++){
                sumArr[i][j] = oriArr[i][j]+ sumArr[i-1][j]+sumArr[i][j-1]-sumArr[i-1][j-1]; 
            }
        }

        // for(int i=0;i<n;i++){             
        //     for(int j=0;j<n;j++){
        //         bw.write(sumArr[i][j]+" ");
        //     }
        //     bw.write("\n");
        // }

        

        for(int t=0;t<testCase;t++){    //test만큼 돌기
                                        // 들어오는 좌표 1,1 이면 인덱스는 0,0

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;
        // x1 이나 y1 이 1일때
        // x1 이나 y1이 x2하고 y2하고 같을떄  조건을 나눠줘야되지않나?
        // 좌표가 같을때는?
        if(x1==0 && y1==0) bw.write(sumArr[x2][y2]+"\n");
        else if (x1==0) bw.write(sumArr[x2][y2]-sumArr[x2][y1-1]+"\n");
        else if (y1==0) bw.write(sumArr[x2][y2]-sumArr[x1-1][y2]+"\n");
        // 같을떄는 따로 안해줘도 된다 왜? 맨아래 식에서 정리가능 
        // else if ((x2==x1)&& (y2==y1)) bw.write(oriArr[x2][y2]+"\n");
        else bw.write(sumArr[x2][y2]-sumArr[x1-1][y2]-sumArr[x2][y1-1]+sumArr[x1-1][y1-1]+"\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }
}