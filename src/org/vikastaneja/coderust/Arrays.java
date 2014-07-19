package org.vikastaneja.coderust;

/**
 * Created by vikastaneja on 3/31/14.
 */
public class Arrays {

    /**
     * Count number of elements in a sorted array
     * Approaches we discussed:
     * 1. Having a hashtable - O(length of the array)
     * 2. Having binary search and then linear for the both sides
     * 3. Having binary search to find out high and low indices.
     * Implemented #3 below.
     * @param sorted
     * @param number
     * @return
     */
    public static int count(int[] sorted, int number) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        if (sorted.length == 0)
            return -1;

        int low = lowIndex(sorted, number);

        int high = highIndex(sorted, number);

        // In any case, either both high and low are -1 or both are between 0 and sorted.length - 1
        return (high >=0 && low >= 0) ? high - (low - 1) : 0;

    }

    /**
     * Helper class for {@link org.vikastaneja.coderust.Arrays#count(int[], int)} for find the leftmost index
     * @param sorted
     * @param n
     * @return
     */
    private static int lowIndex(int[] sorted, int n) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        int low = 0;
        int high = sorted.length - 1;
        int mid = high/2;

        while (low <= high) {
            int m = sorted[mid];

            if (m < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (sorted[low] == n) return low;
        return -1;

    }

    /**
     * Helper class for {@link org.vikastaneja.coderust.Arrays#count(int[], int)} for find the rightmost index
     * @param sorted
     * @param n
     * @return
     */
    private static int highIndex(int[] sorted, int n) {

        if (sorted == null)
            throw new NullPointerException("Array passed is null");

        int low = 0;
        int high = sorted.length - 1;
        int mid = high/2;

        while (low <= high) {
            int m = sorted[mid];

            if (m <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (sorted[high] == n) return high;
        return -1;
    }
}
