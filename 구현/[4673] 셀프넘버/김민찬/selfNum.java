import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class selfNum{
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] num = new boolean[10000]; // 초기값을 다 false

        for(int i=1; i<10000;i++){
            
            int constructor = 0;

            if(i<10) constructor = i + i%10;
            else if(i<100) constructor = i + i/10 + i%10;
            else if(i<1000) constructor = i + i/100 + i%100/10 + i%10;
            else if(i<10000) constructor = i + i/1000 + i%1000/100 + i%100/10 + i%10;
            if(constructor>=10000)continue;
            num[constructor] = true;
        }
    
        for(int i=1;i<10000;i++){ // 0제외
            if(num[i]==false) bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
    
}
