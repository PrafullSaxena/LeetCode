class Solution {
    public void reverseString(char[] s) {
        s = BruteForce(s);
    }
    
    
    public char[] BruteForce(char[] s){
        int leftPointer = 0;
        int rightPointer = s.length - 1;

        while(leftPointer < rightPointer){
            char temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        return s;
    }
}
