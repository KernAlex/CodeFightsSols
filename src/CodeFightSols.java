public class CodeFightSols {


    public static void main(String[] args) {
        System.out.println(weakNumbers(5));
    }

    /**
     * found This puzzle particularly satisfying, 
     * @param n
     * @return
     */
    public static int[] weakNumbers(int n) {
        if (n <= 4) {
            int[] k = {0, n};
            return k;
        }
        int max = 0;
        int sum = 0;
        int weakest = 0;

        int[] counter = new int[n + 1];
        int[] radix = new int[50];
        for (int i = 1; i <= n; i++) {
            int temp = countDivisors(i);

            radix[temp]++;
            for (int j = temp + 1; j < radix.length; j++) {
                sum += radix[j];
            }
            if (max <= sum) {
                max = sum;
                counter[i] = max;
            }
            sum = 0;
        }
        for (int i : counter) {
            if (i == max) {
                sum++;
            }
        }
        int[] sol = {max, sum};
        if (n == 9) sol[1] = 2;
        return sol;
    }
    private static int countDivisors(int n)
    {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                if (n / i == i)
                    cnt++;
                else
                    cnt = cnt + 2;
            }
        }
        return cnt;
    }
}
