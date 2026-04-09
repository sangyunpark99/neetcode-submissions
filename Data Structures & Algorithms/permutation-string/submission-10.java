class Solution {

    private HashMap<Character, Integer> contain = new HashMap<>();
    private HashMap<Character, Integer> window = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        
        for(char value: s1.toCharArray()) {
            contain.put(value, contain.getOrDefault(value, 0) + 1);
        }

        char[] s2Char = s2.toCharArray();
        for(int i = 0; i < s1.length(); i++) {
            window.put(s2Char[i], window.getOrDefault(s2Char[i], 0) + 1);
        }

        int left = 0;
        int right = s1.length();

        while(right < s2.length()) {

            if(check()) {
                return true;
            }

            char rightValue = s2Char[right++];
            char leftValue = s2Char[left++];

             window.put(rightValue, window.getOrDefault(rightValue, 0) + 1);
             window.put(leftValue, window.getOrDefault(leftValue, 0) - 1);
             if(window.get(leftValue) <= 0) window.remove(leftValue);
        }

        if(check()) return true;

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
