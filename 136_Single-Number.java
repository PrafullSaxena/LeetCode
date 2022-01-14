class Solution {
    public int singleNumber(int[] nums) {
        // return BruteForce(nums);   // 378 ms 
        // return WithSpace(nums);  // 902 ms
        // return Optimized(nums);  // 1 ms
        // return ExtraSpaceMap(nums); // 14 ms
        return WithSpaceArrayList(nums); //722 ms 
    }
    
    
    public int Optimized(int[] nums){
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        
        return result;
    }
    
    public int WithSpace(int[] nums) {
        
        List<Integer> list = new LinkedList<>();

        for(Integer i : nums){
            if(list.contains(i)){
                list.remove(i);
            }else{
                list.add(i);
            }
        }
       return list.get(0);
    }
    
        public int WithSpaceArrayList(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for(Integer i : nums){
            if(list.contains(i)){
                list.remove(i);
            }else{
                list.add(i);
            }
        }
       return list.get(0);
    }
    
    public int ExtraSpaceMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i : nums){
            if(map.containsKey(i)){
                map.remove(i);
            }else{
                map.put(i, 0);
            }
        }
        
        return (int) map.keySet().toArray()[0];

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
