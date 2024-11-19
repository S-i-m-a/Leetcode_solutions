public class Solution {
    public int romanToInt(String s) {
        int[] values = new int[26]; // Array to store Roman numeral values
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = values[s.charAt(i) - 'A'];

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("III -> " + solution.romanToInt("III"));       // Output: 3
        System.out.println("LVIII -> " + solution.romanToInt("LVIII"));   // Output: 58
        System.out.println("MCMXCIV -> " + solution.romanToInt("MCMXCIV")); // Output: 1994
    }
}
