class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int half = (n + m) / 2;

        int left = 0;
        int right = n;

        while(left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int nums1Left = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1Right = i < n ? nums1[i] : Integer.MAX_VALUE;
            int nums2Left = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = j < m ? nums2[j] : Integer.MAX_VALUE;

            if(nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if((n + m) % 2 == 1) { // 홀수면
                    return Math.min(nums1Right, nums2Right);
                }
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
            }else if(nums1Left > nums2Right) {
                right = i - 1;
            }else {
                left = i + 1;
            }
        }

        return -1;
    }
}
