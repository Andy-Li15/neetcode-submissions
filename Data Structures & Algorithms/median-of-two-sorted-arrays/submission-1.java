// incomplete solution that passes test cases
/*
Preparation:
    Partition nums1 with binary search to solve in O(lg(n + m))

    Let nums1 be partitioned into Aleft and Aright
    Let aleft = mid1 is the end of Aleft, and aright is the start of Aright
    Let nums2 be partitioned into Bleft and Bright
    Let bleft = mid2 is the end of Bleft, and bright is the start of Bright

    Let num1 be smaller than num2
    This way, Aleft may be empty but Bleft will not
    Unless both nums1 and nums2 are empty

    Let total = nums1.length + nums2.length, half = total / 2

Steps:
    Bleft contains half - size(Aleft) elements, where size(Aleft) = mid1 - 1
    So mid2 = half - (mid1 - 1) - 1

    For the partition to be valid, aleft and bleft <= aright and bright
    We know aleft <= aright and bleft <= bright since arrays sorted
    So just check if aleft <= bright and bleft <= aright
    If so, then 
        if total is odd, return Math.min(aright, bright)
        if total is even, return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0
    Else if aleft > bright, num1 partition is too big, right = mid - 1
    Else bleft > aright, num1 partition is too small, left = mid + 1
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // let nums1 be the smaller array
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int half = total / 2;

        if (total == 0) return 0;

        int left = 0;
        int right = len1 - 1;
        // there will always be a median unless total == 0
        // using True allows left1 to be empty
        while (true) { 
            int mid1 = left + (right - left) / 2; // 1st partition

            if (left + right == -1) mid1 = -1; // simulate rounding down
            
            int mid2 = half - mid1 - 2; // 2nd part has half - mid1 - 1 elements

            // if index out of bounds, treat as negative or positive infinity
            int left1 = (mid1 >= 0) ? nums1[mid1] : Integer.MIN_VALUE;
            int right1 = (mid1 + 1 < len1) ? nums1[mid1 + 1] : Integer.MAX_VALUE;
            int left2 = (mid2 >= 0) ? nums2[mid2] : Integer.MIN_VALUE;
            int right2 = (mid2 + 1 < len2) ? nums2[mid2 + 1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 1) { // odd
                    return Math.min(right1, right2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }
    }
}
