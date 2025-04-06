class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] res = new int[10];
        res[0] = count['z' - 'a'];
        res[2] = count['w' - 'a'];
        res[4] = count['u' - 'a'];
        res[6] = count['x' - 'a'];
        res[8] = count['g' - 'a'];

        res[3] = count['h' - 'a'] - res[8];
        res[5] = count['f' - 'a'] - res[4];
        res[7] = count['s' - 'a'] - res[6];

        res[1] = count['o' - 'a'] - res[0] - res[2] - res[4];
        res[9] = count['i' - 'a'] - res[5] - res[6] - res[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (res[i]-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
