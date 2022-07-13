//package 구현.[1026] 보물.김민찬;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class treasure {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        //B는 재배열하면안된다
        //B를 복사해서 C를 만들고...
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for(int i=0; i<N ; i++){
            A.add( Integer.parseInt(st1.nextToken()));
            B.add( Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        int answer=0;
        for(int i =0;i<N ;i++){
            answer += A.get(i)*B.get(i);
        }
        System.out.println(answer);
    }
}
