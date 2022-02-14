class Solution {
    public boolean isPalindrome(String s) {
        return withTwoPointer(s);
    }
    
    public boolean withTwoPointer(String s){
            int leftPointer = 0;
            int rightPointer = s.length() - 1;

            s = s.toLowerCase();

            while(leftPointer < rightPointer){

               String leftChar = ""+s.charAt(leftPointer);
               String rightChar = ""+s.charAt(rightPointer);

                if(!leftChar.matches("[a-z0-9]")){
                    leftPointer++;
                    continue;
                }

                if(!rightChar.matches("[a-z0-9]")){
                    rightPointer--;
                    continue;
                }

                if(s.charAt(leftPointer) != s.charAt(rightPointer)){
                    return false;
                }

                leftPointer++;
                rightPointer--;
            }

            return true;
    }
}
