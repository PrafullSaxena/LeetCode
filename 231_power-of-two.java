class Solution {
    public boolean isPowerOfTwo(int n) {
       //return BruteForce(n);
        return withBits(n);
    }
    
    public boolean withBits(int number){
        
        if(number == 1) return true;
        
        for(int i=0; i < 31; i++){
            int dummyNumber = 1<< i;
            if(dummyNumber == number) return true;
        }
        
        
        
        return false;
    }
    
    
    public boolean BruteForce(int number){
        
        int power = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
    
        for(int i=0; i < 31; i++){
            
            power = FastPower(2, i);
            
            map.put(power, i);
            
        }
        
        return map.containsKey(number);
    }
    
    
    public int FastPower(int number, int power){
        
        if(power == 0){
            return 1;
        }
        
        return FastPower(number, power -1) * number;
    }
    
}
