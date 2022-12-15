import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        int[] pos = {0,0};
        for(int i =0;i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if(a.equals("E")){
                pos[0]=pos[0]+dx[0]*b;
            }
            else if(a.equals("W")){
                pos[0]=pos[0]+dx[1]*b;   
            }
            else if(a.equals("S")){
                pos[1]=pos[1]+dy[2]*b;
            }
            else{
                pos[1]=pos[1]+dy[3]*b;
            }
        }
        bw.write(pos[0]+" "+pos[1]);
        bw.flush();

        

    }
}