class Solution {

    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        int answer = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] >= nums[left]) {
                answer = Math.min(answer, nums[left]);
                left = mid + 1;
            }else if(nums[mid] <= nums[right]) {
                answer = Math.min(answer, nums[mid]);
                right = mid - 1;
            }
        }

        return answer;
    }
}
