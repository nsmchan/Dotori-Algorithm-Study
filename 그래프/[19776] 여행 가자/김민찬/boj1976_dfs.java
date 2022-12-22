import java.io.*;


// 행렬 or List
// dfs행렬

public class boj1976_dfs{
    
    static int node=0;
    static int targetCnt=0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        node = Integer.parseInt(br.readLine()); 
        targetCnt = Integer.parseInt(br.readLine());
        

        String[][] city = new String[node][node];
        boolean[] visited = new boolean[node];

        // 행렬 받기
        for(int i=0; i<node; i++){
            city[i]=br.readLine().split(" ");
            //city[i][i]="1";
        }
        // 타겟 시티
        String[] targetCity = br.readLine().split(" ");

        int cnt=0;
        // 모든 도시 DFX 해야됨
        for(int i=0;i<node;i++){
            
            // 방문체크를 해버리면
            // 타깃시티 트루 조건문이 다 성공해버림
            // BFS 가 끝나면 타깃시티 조건 확인후 방문체크 초기화
            DFS(i,city,visited);

            // 확인
            for(int j=0; j<targetCnt;j++){
                if(visited[Integer.parseInt(targetCity[j])-1]==true){
                    cnt++;
                }
            }
            if(cnt==targetCnt){
                bw.write("YES");
                bw.flush();
                return;
            }
            // yes가 아니니까 다시 초기화
            visited = new boolean[node+1];    
            cnt=0;
        }
        //DFS 끝났는데 YES가 안나왔으니까
        bw.write("NO");
        bw.flush();
    }

    public static void DFS(int idx, String[][] city,boolean[] visited){
        
        visited[idx]=true; // 자기자신 방문처리해줘야돼
        
        for(int i=0; i<node;i++){
            if(city[idx][i].equals("1") && visited[i]==false){
                visited[i]=true;
                DFS(i,city,visited);
            }
        }
    }
}