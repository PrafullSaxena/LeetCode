class Solution {
    public int singleNumber(int[] nums) {
        
        return BruteForce(nums);
        
    }
    
    
    public int BruteForce(int[] nums){
        int result; 
        
        for(int i = 0; i < nums.length; i++){
            
            boolean flagI = false;
            for(int j = 0; j < nums.length; j++){
                
                boolean flagJ = false;
                for(int k=0; k < nums.length; k++){
                    
                    if( (i != j && j != k) && nums[i] == nums[j] && nums[j] == nums[k]){
                        flagJ = true;
                        break;
                    }
                }
                
                if(flagJ){
                    flagI = true;
                    break;
                }
            }
            
            if(!flagI){
                return nums[i];
            }
        }
        
        return 0;
    }
}
