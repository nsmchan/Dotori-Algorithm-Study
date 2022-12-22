import java.io.*;
public class boj1463 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        while(n!=1){
            if(n==1) break;
            if(n%3==0) {
                n=n/3;
                cnt++;
            }
            else if(n%2==0) {
                n=n/2;
                cnt++;
            }
            else {
                n--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
