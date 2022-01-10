/*

    BruteForce 
        timeComplexity - O(n^2)
        spaceComplexity - O(1)
        
   Optimized
        timeComplexity - O(n)
        spaceComplexity - O(n)
        
   Both the function will return the list of elements whos sum is equals to target.

*/

import java.util.*;

public class SumPair {

    public List<List<Integer>> optimized(int[] nums, int target){

        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> previousElement = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > target) continue;
            int key = target - nums[i];
            
            if(previousElement.contains(key)){
                resultSet.add(List.of(nums[i], key));
            }else previousElement.add(nums[i]);
        }
        return resultSet;
    }


    public List<List<Integer>> BruteForce(int[] nums, int target){
        
        List<List<Integer>> resultSet = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > target) continue;
                
                if(nums[i] + nums[j] == target) {
                    resultSet.add(List.of(nums[i], nums[j]));
                }
            }
        }
        
        return resultSet;
    }

}
