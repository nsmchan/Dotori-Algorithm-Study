import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] people, int limit) throws IOException {
        int answer = 0;
        int size = people.length;

        // // 버블정렬 --> 시간초과 ㅋ
        // for(int i=0;i<size;i++){
        //     for(int j=0; j<size-1;j++){
        //         if(people[j]>people[j+1]){
        //             int tmp=people[j];
        //             people[j]=people[j+1];
        //             people[j+1]=tmp;
        //         }
        //     }
        // }
        Arrays.sort(people);

        int x=0;
        int y=size-1;
        
        while(x<=y){
            if(people[x]+people[y] > limit){
                y--;
                answer++;
            }
            else{
                x++;
                y--;
                answer++;
            }
        }
    
        
        return answer;
        
    }
}