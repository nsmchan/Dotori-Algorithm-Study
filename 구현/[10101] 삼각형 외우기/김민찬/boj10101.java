import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class boj10101{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        int a3 = Integer.parseInt(br.readLine());
        int sum = a1+a2+a3;
        System.out.println(a1+" "+a2+" "+a3+" "+sum);
        if(a1==60 && a2==60 && a3==60) bw.write("Equilateral");
        else if(sum==180 && ( (a1==a2 && a1!=a3) || (a1==a3 && a1!=a2) || (a2==a3 && a2!=a1) ) ){
            bw.write("Isosceles");
        }
        else if(sum==180 &&a1!=a2 && a1!=a3 && a2!=a3){
            bw.write("Scalene");
        }
        else {
            bw.write("Error");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}