class Solution {
    public int[] searchRange(int[] nums, int target) {    
        return BruteForce(nums, target);
    }
    
    
    public int[] BruteForce(int[] nums, int target){
        
        int[] result = {0,0};
        boolean flag = false;
        int totalFind = 0;
        
        //[5,7,7,8,8,10], 8 
        
        for(int i=0; i< nums.length; i++){
            if(nums[i] == target){
                if (totalFind == 0){
                    result[0] = i;
                    result[1] = Math.max(result[1], i);
                }else{
                    result[0] = Math.min(result[0], i);
                    result[1] = Math.max(result[1], i);
                }
                flag = true;
                totalFind++;
            }
        }
        
        return (flag) ? result : new int[] {-1,-1};
    }
}
