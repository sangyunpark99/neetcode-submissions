class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] values = s.toCharArray();
        
        if(s.isEmpty()) return 0;

        int left = 0;
        int right = left + 1;
        set.add(values[left]);
        int answer = 1;
        int cur = 1;
        while(right < values.length) {
            char rv = values[right];
            char lv = values[left];
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
