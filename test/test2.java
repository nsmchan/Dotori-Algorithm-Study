import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class test2{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());
        int[]board;            // 게임판
        int[] card = new int[6];// 카드
        int answer;             // 답
        
        for(int t=1; t<=testcase ; t++){
            st = new StringTokenizer(br.readLine());
            int boardSize = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int total=(boardSize-1)*4;
            answer=0;

            // 초기화
            board = new int[total];

            // 카드 n개
            for(int i=0;i<6;i++){
                card[i]=n;
            }

            // 게임판 만들기 
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<total ;i++){
                board[i] = Integer.parseInt(st.nextToken());
            }






            bw.write("#"+t+" "+ answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

// 테케
// 3
// 6 1 
// 0 400 300 200 100 500 700 900 500 500 400 300 700 400 800 900 200 300 300 400
// 6 1
// 0 500 400 500 600 700 800 900 1000 600 400 300 700 1500 400 100 0 700 200 500
// 11 2
// 0 500 100 200 300 500 700 500 600 300 400 500 100 200 800 100 500 600 400 300 200 0 400 100 300 800 700 200 300 400 700 600 0 300 200 500 400 300 1000 2000

// #1 1200
// #2 1300
// #3 1300