class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>();
        char[] values = s.toCharArray();
        
        if(s.isEmpty()) return 0;

        int left = 0;
        int right = left + 1;
        set.add(String.valueOf(values[left]));
        int answer = 1;
        int cur = 1;
        while(right < values.length) {
            String rv = String.valueOf(values[right]);
            String lv = String.valueOf(values[left]);
            if(!set.contains(rv)) {
                set.add(rv);
                cur++;
                answer = Math.max(answer, cur);
                right++;
            }else {
                set.remove(lv);
                cur--;
                left++;
            }
        }

        return answer;
     }
}
