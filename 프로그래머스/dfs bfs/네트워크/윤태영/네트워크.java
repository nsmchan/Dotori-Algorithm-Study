import java.util.*;
class Solution {
    static boolean invisited[][];
    static int count;
    public int solution(int n, int[][] computers) {
        int answer = 0;
       
        invisited=new boolean[n][n];
        for(int i =0; i< n;i++){
          count=0;
          DFS(i,computers);           
            if(count>0){    
                answer++;            
            }
        }     
        return answer;
    }    
    static void DFS(int s, int [][]computers){               
         if(invisited[s][s]==false){ // 자기 자신이 방문이 안되어 있는 예외
         invisited[s][s]=true;   
          count++;
         }
         for(int i=0; i<computers.length;i++){      //방문 x, 연결 o
             if(invisited[s][i]==false && computers[s][i]==1){
                 invisited[s][i]=true;  
                 count++;
                 DFS(i,computers);                 
             }
                       
         }
               
    }
}
