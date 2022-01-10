
public class SumPair {

    public List<List<Integer>> Oprimized(int[] nums, int target){

        Map<Integer, Integer> bucket = new HashMap<>();
        List<List<Integer>> resultSet = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){

            if(nums[i] > target) continue;
            
            List<Integer> temp = new ArrayList<>();
            
            int key = target - nums[i];
            if(bucket.containsKey(key)){
                temp.add(nums[i]);
                temp.add(key);
                resultSet.add(temp);
            }else {
                bucket.put(nums[i], i);
            }
        }
        return resultSet;
    }

}
