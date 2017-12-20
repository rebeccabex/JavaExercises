package AdvancedExercises;

import java.util.ArrayList;

public class PrimeNumbers {

    private ArrayList<Integer> primeList;

    public PrimeNumbers() {



    }

    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
    }

    public boolean isPrime(int n, ArrayList<Integer> currentPrimes) {

        for (Integer p: currentPrimes) {
            if((n / p) * p == n) {
                return true;
            } else if (Math.pow(p, 2) > n) {
                return false;
            }
        }
        return false;
    }

}
