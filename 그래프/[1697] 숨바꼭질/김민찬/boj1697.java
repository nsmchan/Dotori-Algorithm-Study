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

        // 같으면 종료
        if(n==k){   
            bw.write(0+" ");
            bw.close();
            br.close();
            return;
        }

        visited = new boolean[100001];
        line = new int[100001];
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

            int now = q.poll();
            for(int i=0;i<3;i++){
                int now2=0;
                if(i==0) {
                    if(now==0) continue; // 인덱스 음수
                    now2 = now-1;
                }
                else if(i==1){
                    now2=now+1;
                }

                else if(i==2){
                    now2=now*2;
                }
                // 배열크기줄이고 조건추가
                if(now2>=100001) continue;
                if(!visited[now2] ){
                    q.add(now2);
                    visited[now2]=true;
                    line[now2]=line[now]+1;

                }
                
            }

        }
    }
    
}
