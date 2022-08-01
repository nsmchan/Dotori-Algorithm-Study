import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class bunyeo{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t;i++){  //테스트 케이스
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] resident = new int[k+1][n];    // 0층부터 k층까지 k층이면 인덱스 k 하고싶어
                                                // 1호부터 n 호까찌  3호에살면 인덱스는 2호
            for(int j=0; j<n;j++){      //0층 i호에는 i명
                resident[0][j] = j+1;
            }
            // a층의 b 호에 살려면 자신의 아래층의 1호~b 호까지 합친수만큼
            
            for(int j=1; j<k+1;j++){    //1층부터  아래층과 같은층 전호수 더해서 구하기
                for(int m=0; m<n;m++){
                    if(m!=0)resident[j][m] = resident[j-1][m] + resident[j][m-1];
                    else resident[j][m] = resident[j-1][m];
                }
            
            }
            bw.write(resident[k][n-1]+"\n");
        }
                    
        bw.flush();
        bw.close();
        br.close();

    }
}