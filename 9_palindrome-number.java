class Solution {
    public boolean isPalindrome(int x) {
        return BruteForce(x);
    }
    
    public boolean BruteForce(int n){
        
        int rev = 0;
        int actualNumber = n;
        
        while( n > 0){
            
            int temp = n % 10;
            n = n / 10;
            
            rev = (rev * 10) + temp ;
            
        }
        
        if (actualNumber == rev) {
            return true;
        }else {
            return false;
        }
        
    }
}
