
import java.util.*;

class Solution {
    
    static int[] cost;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        int[] cost = new int[words.length];
        boolean[] visited = new boolean[words.length];
        
        BFS(begin, target, words, visited, cost);
        
        // words에서 target에 해당하는 인덱스 구하고
        int idx=-1;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)) idx=i;
        }
        if(idx==-1) return 0;
        return cost[idx];
    }
    
    public static void BFS(String begin, String target, String[] words,
                          boolean[] visited, int[] cost){
        
        Queue<String> q = new LinkedList<>();
        
        int dif = 0;
        String[] beginArr = begin.split("");
        String[] wordsArr = new String[begin.length()];
        for(int i=0;i<words.length;i++){
            wordsArr = words[i].split("");
            
            // 문자 한글자씩 비교
            dif=0;
            for(int j=0; j<begin.length();j++){
                if(!beginArr[j].equals(wordsArr[j])){
                    dif++;
                }
            }
            if(dif<=1){
                q.add(words[i]);
                cost[i]=1;
                visited[i]=true;
            }
        }

        while(!q.isEmpty()){
            String nowStr = q.poll();
            int nowIdx=0;
            for(int i=0; i<words.length; i++){
                if(nowStr.equals(words[i])){
                    nowIdx=i;
                    break;
                }
            }
            String[] nowArr = nowStr.split("");
            
            for(int i=0;i<words.length;i++){
                wordsArr = words[i].split("");
                dif=0;
                for(int j=0; j<nowStr.length();j++){
                    if(!nowArr[j].equals(wordsArr[j])){
                        dif++;
                    }
                }
                if(dif<=1 && visited[i]==false){
                    q.add(words[i]);
                    cost[i]=cost[nowIdx]+1;
                    visited[i]=true;
                }
            }   

        }
        
    }
}
