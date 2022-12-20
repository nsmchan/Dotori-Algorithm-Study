import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
     List<Integer> list=new ArrayList<>();
    
    for(int i=0;i<nums.length;i++)
        { 
            if(!list.contains(nums[i]))
            {
                list.add(nums[i]);
            }
        }
        for(Integer i : list){
            System.out.print(i);
        }
    if(list.size()<nums.length/2)    
           answer=list.size();
        else answer=nums.length/2;
        return answer;
    }
}