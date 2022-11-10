import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class supervisor{

	     public static void main(String[] args) throws IOException{
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	   
		     int N = Integer.parseInt(br.readLine());
             StringTokenizer st = new StringTokenizer(br.readLine());
             StringTokenizer st2 = new StringTokenizer(br.readLine());
             

		     int A[] = new int[N];
		     for(int i=0;i<N;i++) {
		    	 A[i]= Integer.parseInt(st.nextToken());
		     }	     
		     int B=Integer.parseInt(st2.nextToken());
		     int C=Integer.parseInt(st2.nextToken());

		        long sum=N;
		        for(int i=0;i<N;i++){
		            A[i]=A[i]-B;
	                if(A[i]<0) A[i]=0;
		            if(A[i]%C!=0){
		                sum=sum+A[i]/C+1; 
		            }
		            else{
		                sum=sum+A[i]/C;
		            }
		        }
		        System.out.println(sum);
		    }
}
      