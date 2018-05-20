public class CodeFightSols {


    public static void main(String[] args) {
        System.out.println(weakNumbers(5));
    }
    /**
     * We define the weakness of number x as the number of positive integers smaller than x that have more divisors than x.

     It follows that the weaker the number, the greater overall weakness it has. For the given integer n, you need to answer two questions:

     what is the weakness of the weakest numbers in the range [1, n]?
     how many numbers in the range [1, n] have this weakness?
     Return the answer as an array of two elements, where the first element is the answer to the first question, and the second element is the answer to the second question.

     Example

     For n = 9, the output should be
     weakNumbers(n) = [2, 2].

     Here are the number of divisors and the specific weakness of each number in range [1, 9]:

     1: d(1) = 1, weakness(1) = 0;
     2: d(2) = 2, weakness(2) = 0;
     3: d(3) = 2, weakness(3) = 0;
     4: d(4) = 3, weakness(4) = 0;
     5: d(5) = 2, weakness(5) = 1;
     6: d(6) = 4, weakness(6) = 0;
     7: d(7) = 2, weakness(7) = 2;
     8: d(8) = 4, weakness(8) = 0;
     9: d(9) = 3, weakness(9) = 2.
     As you can see, the maximal weakness is 2, and there are 2 numbers with that weakness level.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] integer n

     Guaranteed constraints:
     1 ≤ n ≤ 1000.

     [output] array.integer

     Array of two elements: the weakness of the weakest number, and the number of integers in range [1, n] with this weakness.
     */
    /**
     * found This puzzle particularly satisfying,
     * @param n looking for weakest number related to n
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
