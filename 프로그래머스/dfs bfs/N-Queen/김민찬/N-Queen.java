class Solution {
    
    // 8방향 체크 시계방향
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int range=0;
    static int cnt=0;
    static int answer = 0;
    
    public int solution(int n) {
        range=n;
        cnt=n;// 체스말 충전
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            DFS(0,i,board);
            cnt=n;
            
            // 배열체크
            for(int k=0;k<n;k++){
                for(int j=0;j<n;j++){
                    
                    System.out.print(board[k][j]);
                }
                System.out.println();
            }
            System.out.println();
            
            //초기화
            board = new int[n][n];
        }
        
        
        return answer;
    }
    
    public static void DFS(int y, int x, int[][] board){
        
        
        board[y][x]++; // 체스말 두기
        
        // 체스말에 따른 배열에 값 계산하기
        for(int i=0; i<8;i++){
            // 8방향 계산
            int nowY= y+dy[i];
            int nowX= x+dx[i];
            if(!checkRange(nowY,nowX))continue;
            // 범위이내까지만
            while(checkRange(nowY,nowX)){
                board[nowY][nowX]++;
                nowY=nowY+dy[i];
                nowX=nowX+dx[i];
                
            } 
        }
        
        cnt--;  // 체스말 카운트 빼기
        // 체스말이 다 두어졌다면 answer++
        if(cnt==0){
            answer++;
            return;
        }
        
        // 조건 보고 dfs 
        for(int i=0; i<range;i++){
            if(y+1==range) return;
            if(board[y+1][i]==0){
                DFS(y+1,i,board);
                //체스말빼기
                board[y+1][i]--;
                // 뺄때 증가시킨 값을 같이 빼주기
                /////////////////////////////////
                // 배열에 값 계산하기
                for(int k=0; k<8;k++){
                    // 8방향 계산
                    int nowY= y+1+dy[k];
                    int nowX= i+dx[k];
                    if(!checkRange(nowY,nowX))continue;
                    // 범위이내까지만
                    while(checkRange(nowY,nowX)){
                        board[nowY][nowX]--;
                        nowY=nowY+dy[k];
                        nowX=nowX+dx[k];
                    }
                }
                /////////////////////////////////
                cnt++;// 뺐으니까 체스말 카운트 ++
            }
        }
    }
    
    public static boolean checkRange(int y, int x){
        // 범위 밖이면 false 반환하기
        if(y < 0 || x < 0 || range<=y || range<=x) return false;
        return true;
    }
}