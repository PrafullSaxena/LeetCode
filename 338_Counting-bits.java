class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n+1];
        
        for(int i=0; i <= n; i++){
            
            int setBits = 0;
            int tempNum = i;
            while(tempNum != 0){
                setBits++;
                tempNum = tempNum & (tempNum -1);
            }
            
            result[i] = setBits;
        }
        
        return result;
    }
}
