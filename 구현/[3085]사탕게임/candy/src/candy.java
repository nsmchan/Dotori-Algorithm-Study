import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class candy{

   static int max=0;
   static int N;
   public static void main(String[]args)throws IOException{
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   N=Integer.parseInt(br.readLine()); // 크기 
   char[][]board=new char[N][N];
   for(int i=0;i<N;i++){
         String st=br.readLine();
       for(int j=0;j<N;j++){

        board[i][j]=st.charAt(j);

       }

   }

   for(int k=0;k<N;k++){

       
    for(int p=0;p<N;p++){
    
         swap1(board,k,p);          //왼쪽 
         mapping(board);
         swap2(board,k,p);
         
         swap2(board,k,p);         //오른쪽
         mapping(board);
         swap1(board,k,p);
        
         swap3(board,k,p);       //아래
         mapping(board);
         swap4(board,k,p);
    
         swap4(board,k,p);        //위
          mapping(board);
         swap3(board,k,p);
        }

      }
      
      System.out.println(max);
   
   }
 
   private static void swap1(char[][]b,int f,int r){   // 왼쪽 교환
        char temp;
        if(r!=0){
        temp=b[f][r];
        b[f][r]=b[f][r-1];
        b[f][r-1]=temp;
        }
   }
   private static void swap2(char[][]b,int f,int r){   // 오른쪽 교환
    char temp;
    if(r!=N-1){
    temp=b[f][r];
    b[f][r]=b[f][r+1];
    b[f][r+1]=temp;
       }
   }
    private static void swap3(char[][]b,int f,int r){   // 아래쪽 교환
        char temp;
        if(f!=0){
        temp=b[f][r];
        b[f][r]=b[f-1][r];
        b[f-1][r]=temp;
        }
   }
   private static void swap4(char[][]b,int f,int r){   // 위쪽 교환
    char temp;
    if(f!=N-1){
    temp=b[f][r];
    b[f][r]=b[f+1][r];
    b[f+1][r]=temp;
    }
 }
 private static int mapping(char[][]b){      // 최대의 연속된 수의 개수 찾기
    
    
    for(int i=0;i<b.length;i++){
        int count=1;  
        for(int j=0;j<N-1;j++){
            
             if(b[i][j]==b[i][j+1] ) count++;
             else count=1;     //초기화(연속되지 않은수를 만났을때)
            
             if(count>=max) max=count;
            
        }
    }
    for(int i=0;i<b.length;i++){
        int count=1;  
        for(int j=0;j<N-1;j++){
            
             if(b[j+1][i]==b[j][i]) count++;
             else count=1;
                 
             if(count>=max) max=count;
            
        }
    }
    return max;

 }
}

