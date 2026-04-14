class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int formed = 0;
        int required = need.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++) {
            char value = s.charAt(right);
            window.put(value, window.getOrDefault(value, 0) + 1);

            if(need.containsKey(value) && need.get(value).intValue() == window.get(value).intValue()) {
                formed++; // 중복 포함
            }

            while(formed == required) {
                if(right - left + 1 < minLen) { // 길이가 최소인 경우
                    minLen = right - left + 1;
                    start = left;
                }

                // 왼쪽 파트 줄이기
                char leftValue = s.charAt(left);
                window.put(leftValue, window.get(leftValue) - 1);

                if(need.containsKey(leftValue) && window.get(leftValue) < need.get(leftValue)) {
                    formed--;
                }

                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
