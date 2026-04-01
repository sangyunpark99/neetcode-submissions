class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int left = 0;
        int right = 1;

        if(prices.length == 1) return 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) { // 증가하는 구조
                answer = Math.max(answer, prices[right] - prices[left]);
                right++;
            }else { // 감소하는 구조면 구역 이동
                left = right;
                right = left + 1;
                continue;
            }
        }

        return answer;
    }
}
