public class Solution {
	public int numSetBits(long a) {

        int numOfOne = 0; 

        while (a != 0){
            numOfOne++;
            a = a & (a - 1);
        }

        return numOfOne;
	}
}
