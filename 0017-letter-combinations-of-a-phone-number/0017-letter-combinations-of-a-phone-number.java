import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        String[] phoneMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(result, new StringBuilder(), digits, 0, phoneMap);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index, String[] phoneMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(result, current, digits, index + 1, phoneMap);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}
