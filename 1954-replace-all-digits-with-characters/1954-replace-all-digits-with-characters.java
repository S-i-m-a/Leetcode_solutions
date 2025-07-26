class Solution {
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 1; i < chars.length; i += 2) {
            int shift = chars[i] - '0';
            chars[i] = (char)(chars[i - 1] + shift);
        }
        
        return new String(chars);
    }
}
