class Solution {
    public boolean isPalindrome(int x) {
        return BruteForce(x);
    }
    
    public boolean BruteForce(int actualNumber){
        
        int reverseNumber = 0;
        int num = actualNumber;

        while (num > 0){
            int rem = num % 10;
            reverseNumber = reverseNumber * 10 + rem;
            num /= 10;
        }
        
        return (actualNumber == reverseNumber)? true : false;
    }
}
