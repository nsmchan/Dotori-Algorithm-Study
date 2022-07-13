import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main{
  public static void main(String[]args)throws IOException{
     
   BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
   
   int N=Integer.parseInt(br.readLine());
   int [] A=new int[N];
   int [] B=new int[N];
   int sum=0;
   StringTokenizer st1=new StringTokenizer(br.readLine());
   for(int a=0; a<N;a++){
 
    A[a]=Integer.parseInt(st1.nextToken()); 

   }  
   StringTokenizer st2=new StringTokenizer(br.readLine());
   for(int b=0; b<N;b++){
 
    B[b]=Integer.parseInt(st2.nextToken()); 

   }  
   Arrays.sort(A);  // 오름차순  
   Arrays.sort(B);


   for(int c=0;c<N;c++){

    sum+=A[c]*B[N-1-c];    

   } 
   
  System.out.println(sum);


}

}