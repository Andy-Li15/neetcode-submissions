/*
O(lg(n+m)) using binary search on smaller array
Binary search selects number of elements instead of index

Prep:
    Let nums1 be the smaller array so nums2 can be partitioned
    Let A = nums1 and B = nums2
    Let total = A.length + B.length
    Let A be split in two such that midA is the number of elements in part 1
    Let B be split in two such that midB is the number of elements in part 1
        Xparty/partXy is the yth part of X, or the last/first element of the part

    half = (total + 1) / 2, represents the desired total elements in both part 1s
        so that odd median = Math.max(Apart1, Bpart1)

    If there are midA elements in part 1 of nums1, 
        then there must be half - midA elements in part 1 of nums2

    Partitions may be empty/negative or go out of bounds
        Use -inf for left out of bounds and +inf for right out of bounds

Steps:
    Let left = 0, right = A.length, so left <= size of Apart1 <= right

    For the partition to be valid, part 1 of both arrays <= part 2 of both arrays
    Since arrays are sorted, Apart1 <= Apart2 and Bpart1 <= Bpart2

    Check that Apart1 <= Bpart2 and Bpart1 <= Apart2. If so, median is
        odd case: Math.max(Apart1, Bpart1)
            median is either of the last elements of part 1
        even case: (Math.max(Apart1, Bpart1) + Math.min(Apart2, Bpart2)) / 2.0
            median is the average of (max of both part 1s and min of both part 2s)
    Else if (Apart1 > Bpart2), Apart1 is too large, right = midA - 1
    Else (Bpart2 > Apart1), Apart1 is too small, left = midA + 1

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        if (total == 0) return -1;

        // ensure A is smaller than B
        int[] A = nums1;
        int[] B = nums2;
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;    
        }

        // binary search on A. left <= size of Apart1 <= right
        int left = 0;
        int right = A.length;
        while (left <= right) {
            int midA = left + (right - left) / 2; // size of Apart1
            int midB = half - midA; // size of Bpart1

            // find bound values of where parts meet, or -/+ inf if out of bounds
            int partA1 = (midA > 0) ? A[midA - 1] : Integer.MIN_VALUE;
            int partA2 = (midA < A.length) ? A[midA] : Integer.MAX_VALUE;
            int partB1 = (midB > 0) ? B[midB - 1] : Integer.MIN_VALUE;
            int partB2 = (midB < B.length) ? B[midB] : Integer.MAX_VALUE;

            // check that partition is valid
            if (partA1 <= partB2 && partB1 <= partA2) {
                if ((total & 1) == 1) { // odd
                    return Math.max(partA1, partB1);
                } else { // even
                    return (Math.max(partA1, partB1) + Math.min(partA2, partB2)) / 2.0;
                }
            } else if (partA1 > partB2) { // partA1 too large
                right = midA - 1;
            } else { // partA1 too small
                left = midA + 1;
            }
        }
        return -1;
    }
}
