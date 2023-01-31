class Week3 {
    public static void main(String[] args) {
        int num = 100;
        // 101 means indices 0 to 100
        boolean isPrime[] = new boolean[num+1];
        
        // Assign all elements but 0 and 1 in the isPrime array to true
        for(int i=0; i<isPrime.length; ++i)
        {
            isPrime[i] = true;
        }
        isPrime[0]=isPrime[1]=false;
        // If current number is a prime, then set all multiples of the number to Nonprime numbers. 
        // We get those multiples by add the number itself to j.
        for(int i=2; i<=num; i++)
        {
            if(isPrime[i])
            {
                for(int j=i+i; j<=num; j+=i)
                {
                    isPrime[j] = false;
                }
            }
        }
        
        System.out.println("All primes from 0 to 100 are:");
        int prime = 0;
        for(boolean flag : isPrime)
        {
            if(flag)
            {
                System.out.print(" "+prime);
            }
            prime++;
        }
    }
}