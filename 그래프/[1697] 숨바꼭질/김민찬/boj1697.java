import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class boj1697 {
    
    static boolean[] visited;
    static int[] line;
    static int sec=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100000];
        line = new int[100000];
        for(int i=0;i<line.length;i++){
            line[i]=0;
        }
        BFS(n, k);
        bw.write(line[k]+" ");
        bw.close();
        br.close();
    }


    public static void BFS(int n, int target){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n]=true; 
        line[n]=sec;
        while(!q.isEmpty()){

            if(visited[target]==true) break;
            int now = q.poll();
            
            for(int i=0;i<3;i++){
                int now2=0;
                if(i==0) {
                    if(now==1) continue;
                    now2 = now-1;
                }
                else if(i==1){
                    now2=now+1;
                }

                else if(i==2){
                    now2=now*2;
                }
                if(!visited[now2]){
                    q.add(now2);
                    visited[now2]=true;
                    line[now2]=line[now]+1;

                }
                
            }

        }
    }
    
}
