class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1_000_000_000;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(check(piles, mid, h)) {
                right = mid - 1;
                answer = mid;
            }else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(int[] piles, int k, int h) { // 시간
        int time = 0;
        for(int pile : piles) {
            time += (pile + k - 1) / k;
            if(time > h) return false;
        }

        return time <= h;
    }
}
