import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class wordChecker{
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=0;i<n;i++){
            String st = br.readLine();
            boolean[] alpha = new boolean[26]; // 초기값 false
            // Boolean[] alpha = new Boolean[26]; // 초기값 -> 할당해줘야댐
            for(int j=0;j<st.length();j++){
                if(alpha[st.charAt(j)-97]==false){ //값이 다르다 0이면 트루
                    alpha[st.charAt(j)-97]=true;
                }
                else{   // 이미 트루로 되어있으면
                    if(st.charAt(j)==st.charAt(j-1)){ // 이전글자랑 같은지 확인
                        bw.write(""); //뒤에꺼랑달라서 트루 값이 더해져있다 -> continue
                        
                    }
                    else{   //트룬데 뒤에꺼랑도 다르면 break - 그룹단어가아니니까
                        break;
                    }
                }
                if(j==st.length()-1)  count++;
                
            }    
        }
        bw.write(count+"");
        bw.close();
        br.close();
    }
}
