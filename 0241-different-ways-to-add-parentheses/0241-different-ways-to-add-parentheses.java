import java.util.*;

class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expr) {
        if (memo.containsKey(expr)) return memo.get(expr);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expr.substring(0, i));
                List<Integer> right = diffWaysToCompute(expr.substring(i + 1));

                for (int a : left)
                    for (int b : right)
                        res.add(c == '+' ? a + b : c == '-' ? a - b : a * b);
            }
        }

        if (res.isEmpty()) res.add(Integer.valueOf(expr));
        memo.put(expr, res);
        return res;
    }
}
