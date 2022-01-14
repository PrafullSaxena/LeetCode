class Solution {
    public int[] singleNumber(int[] nums) {
        
        // return Optimized(nums);
        
    }
    
    
    public int[] BruteForse(int[] nums){
        
        
        
    }
    
    public int[] Optimized(int[] nums) {
        

        int aXorB = 0;
        
        for(int i: nums){
            aXorB ^= i;
        }
            
        int mostSigBit = (aXorB & -aXorB);
        
        int firstNum = 0;
        int secondNum = 0; 
        
        for(int i: nums){
            if((i & mostSigBit) > 0){
                firstNum ^= i;
            }else{
                secondNum ^= i;
            }
        }
        
        return new int[] {firstNum, secondNum};
    }
}
