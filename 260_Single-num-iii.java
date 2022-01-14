
/*
            Solution
            
            Step 1) XOR all the elements, lets store it in the variable aXorB, XOR eliminate the same values hence we will left with the XOR of two diff values
            Step 2) (aXorB &  -aXorB)   // After doing XOR our next step is to find the each values from the XOR of them and one way of doing it is to find the 2's compliment and then AND it with the aXorB 
            Step 3) after doing this if we XOR the values with the each elements all the elements will devided in two catagory, 1 which has 1 at the most significance bit and one which has 0
            Step 4) now we can do XOR from each of this bucket and the unique element will be found. 

*/

class Solution {
    public int[] singleNumber(int[] nums) {
        
        // return Optimized(nums);
        // return BruteForce(nums);
        return ExtraSpace(nums);
        
    }
    
    
    public int[] ExtraSpace(int[] nums){
        
        Map<Integer, Integer> bucket = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            if(bucket.containsKey(nums[i])){
                bucket.remove(nums[i]);
            }else{
                bucket.put(nums[i], 0);
            }
        }
        
        int[] result = new int[2];
        
        result[0] = (int) bucket.keySet().toArray()[0];
        result[1] = (int) bucket.keySet().toArray()[1];
        return result;
    }
    
    public int[] BruteForce(int[] nums){
        
        int[] result = new int[2];
        
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            boolean flag = false; 
            
            for(int j = 0; j < nums.length; j++){
                if( (i != j) && nums[i] == nums[j]){
                    flag = true; 
                    break;
                }
            }
            
            if(!flag){
                result[index++] = nums[i];
            }
        }
        
        return result; 
        
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
