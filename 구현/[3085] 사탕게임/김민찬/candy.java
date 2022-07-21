package 김민찬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class candy{
    
    static int max;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        //판만들기
        char[][] board = new char[n][n];
        for(int i=0; i<n ; i++){
             board[i]=br.readLine().toCharArray();
        }

        max=0;
        // 바꾸기전에 계산
        check(board,n);
        // 가로
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                char temp = board[i][j];
                board[i][j]=board[i][j+1];
                board[i][j+1] = temp;
                check(board,n);
                temp = board[i][j];
                board[i][j]=board[i][j+1];
                board[i][j+1] = temp;
            }
        }

        // 세로
        for(int j=0;j<n;j++){
            for(int i=0;i<n-1;i++){
                char temp = board[i][j];
                board[i][j]=board[i+1][j];
                board[i+1][j] = temp;
                check(board,n);
                temp = board[i][j];
                board[i][j]=board[i+1][j];
                board[i+1][j] = temp;
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void check(char[][] board, int n){
       
        //가로
        for(int i=0;i<n;i++){
            int temp=1;
            for(int j=0;j<n-1;j++){
                if(board[i][j]==board[i][j+1]){
                    temp++;
                    if(max<temp) max=temp;
                }else {
                    temp=1;
                }
            }
        }

        //세로
        for(int j=0;j<n;j++){
            int temp=1;
            for(int i=0;i<n-1;i++){
                if(board[i][j]==board[i+1][j]){
                    temp++;
                    if(max<temp) max=temp;
                }else {
                    temp=1;
                }
            }
        }
    }


}