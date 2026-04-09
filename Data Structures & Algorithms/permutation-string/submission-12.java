class Solution {

    private HashMap<Character, Integer> contain = new HashMap<>();
    private HashMap<Character, Integer> window = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;
        
        for(char value: s1.toCharArray()) {
            contain.put(value, contain.getOrDefault(value, 0) + 1);
        }

        char[] s2Char = s2.toCharArray();
        for(int i = 0; i < n; i++) {
            window.put(s2Char[i], window.getOrDefault(s2Char[i], 0) + 1);
        }

        int left = 0;
        int right = n;

        if(check()) return true;

        while(right < m) {

            char rightValue = s2Char[right++];
            char leftValue = s2Char[left++];

             window.put(rightValue, window.getOrDefault(rightValue, 0) + 1);
             window.put(leftValue, window.getOrDefault(leftValue, 0) - 1);

             if(check()) {
                return true;
            }
        }

        return false;
    }

    private boolean check() {

        for(char key: contain.keySet()) {
            if(window.get(key) != contain.get(key)) { // 하나라도 다른 경우
                return false;
            }
        }

        return true;
    }
}
