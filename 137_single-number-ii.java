class Solution {
    public int singleNumber(int[] nums) {
        
        // return BruteForce(nums);
        // return withSpace(nums);
        return sortingApproch(nums);
        //return usingBits(nums);   // NOT WORKING!!!
        
    }
    

    public int usingBits(int[] nums){

        int[] storeBites = new int[33];

        for (int i = 0; i < nums.length; i++) {

            String bin = convertToBinary(nums[i]);

            for (int j = 0; j < bin.length(); j++) {
                int CurrentBit = (bin.charAt(j) == 0)? 0: 1;
                storeBites[j] = storeBites[j] + CurrentBit;
            }
        }
        for (int i = 0; i < storeBites.length; i++) {
            storeBites[i] = storeBites[i] % 3;
        }

        return convertToDecimal(arrayToBinString(storeBites));
    }


    public int fastPower(int number, int power){
        if(power == 0){
            return 1;
        }else{
            return fastPower(number, power - 1) * number;
        }
    }

    public String convertToBinary(int ActualNumber){

        StringBuilder bin = new StringBuilder();
        int number = ActualNumber;
        int rem = 0;
        int div = 0;

        while(number > 1){

            rem = number % 2;
            div = number / 2;
            number = div;
            char addByte = (rem == 0) ? '0' : '1';
            bin.insert(0, addByte);

            if(number == 0 || number == 1){
                char lastByte = (number == 0) ? '0' : '1';
                bin.insert(0, lastByte);
                break;
            }

        }
        return bin.toString();

    }

    public int convertToDecimal(String binValue){

        StringBuilder bin = new StringBuilder(binValue);


        bin.reverse();

        int decimalValue = 0;

        for (int i = 0; i < bin.length(); i++) {
            int currentValue = (bin.charAt(i) == '0') ? 0 : 1;
            int power = fastPower(2, i);
            decimalValue = decimalValue + (currentValue * power);

        }

        return decimalValue;
    }


    public String arrayToBinString(int[] binary){

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < binary.length; i++) {
            char bit = (binary[i] == 0)? '0' : '1';
            builder.insert(0, bit);
        }
        return builder.toString();
    }
//============================================================

    
    
    
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
