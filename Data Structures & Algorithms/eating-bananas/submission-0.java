/*
Time to eat pile = ceil(bananas / rate)

Min rate >= 1
Max rate <= Max(piles)

Find minimum
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minRate = 1;
        int maxRate = max(piles);
        int best = maxRate;
        while (minRate <= maxRate) {
            int midRate = minRate + (maxRate - minRate) / 2;
            int hours = hoursRequired(piles, midRate);
            if (hours <= h) { 
                // new best found, see if there is lower rate that works
                best = midRate;
                maxRate = midRate - 1;
            } else {
                // midRate too low
                minRate = midRate + 1;
            }
        }
        return best;
    }

    private int hoursRequired(int[] piles, int rate) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double)pile / rate);
        }
        return total;
    }

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
