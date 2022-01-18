package programs;

//Java program to print all primes smaller than or equal to n using Sieve of Eratosthenes

public class SieveOfEratosthenesPrimeNumberDemo {
    public static void main(String[] args) {

        int n = 50;
        System.out.println("Below are the prime numbers smaller than n = "+ n);

        findAllPrimeNumberLessThanN(n);

    }

    private static void findAllPrimeNumberLessThanN(int n) {

        //You can alternately choose Hashmap to store number and IsPrime as value.
        boolean prime[] = new boolean[n + 1];

        //Assume all numbers are Prime at start.
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        //Starting with 2. Check all number which are divisible
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                // Update all multiples of p. i.e loop thru all numbers
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " - ");
        }
    }
}
