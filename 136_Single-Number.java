class Solution {
    public int singleNumber(int[] nums) {
        // return BruteForce(nums);
        return WithSpace(nums);
        // return Optimized(nums);
    }
    
    
    public int Optimized(int[] nums){
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        
        return result;
    }
    
    public int WithSpace(int[] nums) {
        
        Map<Integer, Integer> bucket = new HashMap<>();
        Integer result = null;
        Stack<Integer> lastResult = new Stack<>(); 
        
        for(int i = 0; i < nums.length; i++){
            if(bucket.containsKey(nums[i])){
                lastResult.pop();
                result = lastResult.peek();
            }else{
                lastResult.push(result);
                result = nums[i];
                bucket.put(nums[i], 0);
            }
        }
        return result; 
    }
    
    
    
    public int BruteForce(int[] nums) {
        
        int result; 
        
        for(int i = 0; i < nums.length; i++){
            Boolean find = false; 
            for(int j = 0; j < nums.length; j++){
                if((i != j ) && nums[i] == nums[j]){
                    find = true;
                    break;
                }
            }
            if(!find){
                return nums[i];
            }
        }
        
        return 0; 
        
    }
    
}
