import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class Main {
   
    static int[]parent;
    public static void main(String[]args)throws IOException {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st=new StringTokenizer(br.readLine());
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());

        parent=new int[n+1];

        //초기화 parent[i]=i
        for (int i = 1; i <=n; i++) {
            parent[i]=i;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int command=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            //command==0 union
           if(command==0){

              union(a,b);

           }else if(command==1){ //command==1 find
               if(find(a)==find(b)){
                  sb.append("YES"+"\n");
               }
               else {
                  sb.append("NO"+"\n");
               }
           }else{
               continue;
           }

        }
        System.out.println(sb);
        br.close();

    }
    static void union(int a, int b){
        // 각각의 부모루트를 구하고 a의 부모루트를 b의 부모 root에 넣어준다
         a=find(a);
         b=find(b);
        if(a!=b) {
           if(a<b){    
            parent[b] = a;
          }else{
             parent[a]=b; 
           }
       }
    }
    static int  find(int a){

        if(parent[a]==a){
            return a;
        }
        else return parent[a]=find (parent[a]);

    }


}