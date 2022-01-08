class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        //return BruteForce(nums, target);
        return Optimum(nums, target);
    }
    
    
    public int[] Optimum(int[] nums, int target){
        
        int firstPointer = 0;
        int secondPointer = 1;
        
        int[] result = new int[2];
        
        while(firstPointer < nums.length -1){
            
            if(secondPointer == nums.length -1){
                firstPointer = firstPointer++;
                secondPointer = firstPointer + 1;
            }
            
            if (nums[firstPointer] + nums[secondPointer] == target){
                result[0] = firstPointer;
                result[1] = secondPointer;
                return result;
            } 
            
        }
        
        return result; 
        
    }
    
    
    public int[] BruteForce(int[] nums, int target) {
        
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result; 
                }
            }
        }
        
        return result;
    }
}
