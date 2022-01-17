class Solution {
    public int singleNumber(int[] nums) {
        
        // return BruteForce(nums);
        // return withSpace(nums);
        return sortingApproch(nums);
        
    }
    
    public int sortingApproch(int[] nums){
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=3) {
            if(i == nums.length - 1){
                return nums[i];
            }else if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    
    
    public int withSpace(int[] nums){

        Map<Integer, Integer> bucket = new HashMap<>();
        int result = 0;

        for(int i:nums){

            if(bucket.containsKey(i)){
                if(bucket.get(i).equals(3)){
                    bucket.remove(i);
                }else{
                    bucket.put(i, bucket.get(i) + 1);
                }
            }else {
                bucket.put(i, 1);
            }
        }

        for(int i : bucket.keySet()){
            if(bucket.get(i).equals(1)){
                result = i;
                return result; 
            }

        }
        return result;
        
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
