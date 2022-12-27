import java.util.*;
import java.io.*;

public class boj15649 {
    
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int n;
    static int m;
    static int depth=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            DFS(i);
            list.remove(list.size()-1); 
            visited = new boolean[n+1];
        }
        
    }

    public static void DFS(int num ){
        list.add(num);
        visited[num]=true;
        if(list.size()==m){  // 백트레킹 조건
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                DFS(i);
                visited[i]=false;
                list.remove(list.size()-1); // 인덱스라서 -1 해서처리
            }
        }
    }
    
}




