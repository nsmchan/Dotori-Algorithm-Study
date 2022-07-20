package test1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class room{
   public static int solution(String str){
         
	   int num[]= new int[10];
	  
        for(int i=0; i< str.length();i++){
            char a = str.charAt(i);
           ///if(a=='9') a='6';  
        	int ia = a-'0'; // char를 int로 변환
       
             num[ia]++;
                
        }
        num[6]=num[6]/2+num[6]%2;
        Arrays.sort(num);
        return num[9];
    }   
    
    public static void main(String[]args)throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String N = br.readLine();
       N=N.replace('9','6');
        
        System.out.println(solution(N)); 
    }   
      
    
}
