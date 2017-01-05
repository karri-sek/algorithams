package test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args){
	Solution s = new Solution();
	int[] nums = {3,2,4,7,0,1,6};
	System.out.println(s.twoSum(nums, 9));
	for(int i: s.twoSum(nums, 9)){
	    System.out.println(i);
	}
    }
    
    public int calculate(String s) {
        
	return 0;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
       for(int i=0;i<nums.length;i++){
           for(int j=i+1; j<nums.length;j++){
               if((nums[i]+nums[j]) == target){
                  result[0] = i;
                  result[1]  = j;
                  return result;
                }
           }
       }
       return null;
    }
}