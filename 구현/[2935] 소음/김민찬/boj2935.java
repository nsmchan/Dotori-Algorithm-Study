import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class boj2935{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger A = new BigInteger(br.readLine());
		String c = br.readLine();
		BigInteger B = new BigInteger(br.readLine());

		if(c.equals("*")){
			bw.write(A.multiply(B)+"");
		}
		else{
			bw.write(A.add(B)+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

      