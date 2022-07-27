import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class break_even_point{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int fix = Integer.parseInt(st.nextToken());
        int vari = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int diff = price-vari;
        if(diff>0){
            bw.write(fix/diff+1+"");
        } 
        else bw.write(-1+"");
        bw.flush();
        bw.close();
        br.close();

    }
}