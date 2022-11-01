import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class dfs{

    // 인접리스트
    // visited[]
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int distance=0;
    static int t1=0;
    static int t2=0;
    static int answer;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node  = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(br.readLine());

        list = new ArrayList[node+1];
        visited = new boolean[node+1];

        // 인접리스트 초기화, 노드수 만큼, 1부터시작
        for(int i=1;i<node+1;i++){
            list[i] = new ArrayList<Integer>();
        }

        // 인접리스트 만들기
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        dfs(t1);
        // 방문이 되지않았으면
        if(visited[t2]==false) answer=-1;
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index){
        if(visited[index] == true){
            return;
        }
        visited[index]=true;// 방문체크
        if(index==t2){
            // 목적지에 도착하면 그때의 거리값 반환
            answer=distance;
            return;
        } 
        for(int i : list[index]){
            if(visited[i]==false){  // 방문하지 않은 노드만 탐색
                distance++;
                dfs(i);
                distance--;
            }
        }
    }

}

