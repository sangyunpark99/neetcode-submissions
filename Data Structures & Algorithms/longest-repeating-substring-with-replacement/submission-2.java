class Solution {
    // 윈도우 안에서 가장 많은 문자를 제외한 나머지를 K번으로 다 바꿀 수 있으면 유효한 윈도우
    public int characterReplacement(String s, int k) {
        char[] value = s.toCharArray();

        int left = 0;
        int right = 0;
        int[] count = new int[26];
        int maxCount = 0;
        int answer = 0;

        while(right < value.length) {
           count[value[right] - 'A']++; // 추가
           maxCount = Math.max(maxCount, count[value[right] - 'A']);
           
           if(right - left + 1 - maxCount > k) { // 바꿀 수 있는게 없다면 왼쪽 범위 축소
              count[value[left++] - 'A']--;
           }

           answer = Math.max(answer, right - left + 1);
           right++; // 항상 증가
        }

        return answer;
    }
}