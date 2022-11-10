import java.util.Arrays;

public class main {

    static boolean num[];
    static int sum,div;
    public static void main(String[]args){
         StringBuilder sb=new StringBuilder();
         num= new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
             sum=0;
            // 1. i부터 생성할수 있는 수를 생성 10000이하
            //  재귀생성 생각 해보자
             int m=i+recursive(i);
            // 2. 생성된 수를 배열 저장
             if(m<=10000) {
                 num[m] = true;
             }
            // 3. false인 배열의 인덱스 값 찾기
            if(num[i]==false) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int recursive(int a){

        sum+=a%10;
        if(a>=10) {
          div= a / 10;
        }
        else{
            return sum;
        }
        return recursive(div);
    }
}
