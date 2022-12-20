import java.util.*;
import java.io.*;

//dfs로 풀어보자 2:20분시작
class Solution {  
    static int answer=0;
    static int sum=0;
    
    public int solution(int[] numbers, int target) {

        DFS(numbers, target,sum,0);
        
        return answer;
    }
    
    
    public static void DFS(int[] numbers, int target, int sum, int idx){
        
        if(idx==numbers.length){
            if(sum==target) answer++;
            return;
        }
        
        DFS(numbers, target,sum+numbers[idx],idx+1);
        DFS(numbers, target,sum-numbers[idx],idx+1);
        

        return;
    }
 
}