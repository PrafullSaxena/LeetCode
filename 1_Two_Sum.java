class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        return MoreOptimized(nums, target);
        // return BruteForce(nums, target);
        // return Optimum(nums, target);
    }
    
    public int[] MoreOptimized(int[] nums, int target){

        Map<Integer, Integer> bucket = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            
            if(bucket.containsKey(target - nums[i])){
                
                return new int[] {
                    bucket.get(target - nums[i]),
                    i
                };   
            }
            
            bucket.put(
                nums[i],
                i
            );
            
        }
        
        return null;
    }
    
    public int[] Optimum(int[] nums, int target){
        
        int firstPointer = 0;
        int secondPointer = 1;
        
        while(firstPointer < nums.length - 1){
              
            if (nums[firstPointer] + nums[secondPointer] == target){
                return new int[] {firstPointer, secondPointer};
            } 
            
            if(secondPointer == nums.length - 1){
                firstPointer = firstPointer+1;
                secondPointer = firstPointer + 1;
            }else {
                secondPointer+=1; 
            }
        }
        
        return null; 
        
    }
    
    
    public int[] BruteForce(int[] nums, int target) {

        
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j}; 
                }
            }
        }
        
        return null;
    }
}
