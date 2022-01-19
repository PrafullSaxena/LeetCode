package CP;

import java.util.Arrays;

public class isPrime {

    public static void main(String[] args) {
       boolean[] isPrime =  checkPrime(12);
        for (int i = 0; i < isPrime.length; i++) {
            System.out.println(i + " --> " + isPrime[i]);
        }
    }

    public static boolean[] checkPrime(int n){
        boolean[] primeArray = new boolean[n+1];

        Arrays.fill(primeArray, true);

        primeArray[0] = false;
        primeArray[1] = false;

        for(int i = 2; i*i <= n; i++){
            for(int j = 2*i; j <=n; j+=i){
                primeArray[j] = false;
            }
        }

        return primeArray;

    }

}
