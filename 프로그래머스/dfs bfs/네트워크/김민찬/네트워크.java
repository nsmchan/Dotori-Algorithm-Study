class Solution {
    
    static boolean[][] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        
        // 방문 초기화
        boolean[][] visited = new boolean[n][n];
        
        
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==true || computers[i][j]==0) continue;
                DFS(i,j,n,computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public static void DFS(int row, int col, int node, int[][] com,boolean[][] visited)
    {
        if(visited[row][col]==true) return;
        visited[row][col]=true;
        visited[col][row]=true;
        for(int i=0;i <node; i++){
            if(com[row][i]==1 && visited[row][i]==false){
                DFS(i,row,node,com,visited);
            }
        }
    }
    
    
}