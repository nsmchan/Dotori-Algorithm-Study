import java.util.*;
import java.io.*;

public class boj5014 {

    static int cnt=0;
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;

    static int[] elevator;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 전체 10
        s = Integer.parseInt(st.nextToken()); // start
        g = Integer.parseInt(st.nextToken()); // goal
        u = Integer.parseInt(st.nextToken()); // up
        d = Integer.parseInt(st.nextToken()); // down

        elevator = new int[f+1];
        visited = new boolean[f+1];

        BFS(s);
        if(visited[g]==false){
            System.out.print("use the stairs");
        }
        else System.out.print(elevator[g]);



    }

    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            int up = now+u;
            if(0<up && up<=f){
                if(visited[up]==false){
                    q.add(up);
                    visited[up]=true;
                    elevator[up]=elevator[now]+1;
                }
            }
            int down = now-d;
            if(0<down && down<=f){
                if(visited[down]==false){
                    q.add(down);
                    visited[down]=true;
                    elevator[down]=elevator[now]+1;
                }
            }
        }
    }
}
