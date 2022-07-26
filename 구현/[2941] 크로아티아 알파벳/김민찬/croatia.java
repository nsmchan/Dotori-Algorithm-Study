import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class croatia{
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strList = {"c=","c-","dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();

        for(int i=0;i<strList.length;i++){
            str=str.replace(strList[i],"1");
        }
        bw.write(str.length()+"");
        bw.close();
        br.close();

    }
}
