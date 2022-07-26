import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class main {

    static int n,e;
    static int k;
    static ArrayList<int[]>adj[];// 인접 노드 배열
    static int dis[]; // 최소 경로 배열
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k =Integer.parseInt(br.readLine());
        adj=new ArrayList[n+1];
        dis=new int[n+1];
        // adj 초기화
        for (int i = 1; i <=n; i++) {
            adj[i]=new ArrayList<int[]>();
        }
        // adj list 에 값 저장
        for (int i = 1; i <= e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); // 츨발
                int v = Integer.parseInt(st.nextToken());  //도착
                int w = Integer.parseInt(st.nextToken()); // 가중치
                adj[u].add(new int[]{v,w}); // u 노드 마다 인접 노드 연결
        }
        dijkstra();
        StringBuilder sb= new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) {
                sb.append(dis[i]+"\n");
            }
            else sb.append("INF"+"\n");
        }

     System.out.println(sb);
    }

    private static void dijkstra(){
        PriorityQueue<Node>pq=new PriorityQueue<Node>();
         //dis배열 INTEGER.MAX_VALUE 무한대 초기화
       /* for (int i = 0; i <=n; i++) {
            dis[i]= Integer.MAX_VALUE;
        }*/
        Arrays.fill(dis, Integer.MAX_VALUE);
        //1. 초기노드 설정-초기화
        dis[k]=0;
        pq.add(new Node(k,0));  // 첫 노드 pq 삽입
        while(!pq.isEmpty()){// pq가 비어 있지 않으면
           Node current= pq.poll();
          if(current.weight>dis[current.vertex]) continue; // 최솟값이 아니면 알고리즘 실행x
            //2. 방문하지 않은 노드중 가장 비용이 적은 노드 선택(그리디 알고리즘)
            for (int follow[]:adj[current.vertex]) {
                if(dis[follow[0]]>dis[current.vertex]+follow[1]) {
                       dis [follow[0]] = dis[current.vertex] + follow[1];
                       pq.add(new Node(follow[0],dis[follow[0]]));
                }
                //3. 해당 노드로부터 갈수 있는 노드들의 비용 갱신 (다이나믹 프로그램)
            }


        }

    }

        public static class Node implements  Comparable<Node> {
            int vertex;
            int weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }

            @Override
            public int compareTo(Node o) {
                return weight - o.weight;

            }

        }


}







