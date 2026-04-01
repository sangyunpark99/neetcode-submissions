class Solution {
    // 오름차순 정렬
    // n번 회전, target의 index를 반환
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = 0;
        int value = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid]) { // 증가하는 배열
                if(value > nums[left]) {
                    value = nums[left];
                    idx = left;
                }
                left = mid + 1;
            }else if(nums[mid] <= nums[right]) { // 증가하는 배열
                if(value > nums[mid]) {
                    value = nums[mid];
                    idx = mid;
                }
                right = mid - 1;
            }
        }

        int a = binarySearch(0, idx - 1, target, nums);
        int b = binarySearch(idx, nums.length - 1, target, nums);
        return Math.max(a,b);
    }

    public int binarySearch(int left, int right, int target, int[] nums) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
