import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        backtrack(num, target, 0, 0, 0, new StringBuilder());
        return res;
    }

    void backtrack(String num, int target, int pos, long eval, long prev, StringBuilder expr) {
        if (pos == num.length()) {
            if (eval == target) res.add(expr.toString());
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') break; // Skip numbers with leading zero
            String part = num.substring(pos, i + 1);
            long val = Long.parseLong(part);
            int len = expr.length();

            if (pos == 0) {
                expr.append(part);
                backtrack(num, target, i + 1, val, val, expr);
                expr.setLength(len);
            } else {
                expr.append("+").append(part);
                backtrack(num, target, i + 1, eval + val, val, expr);
                expr.setLength(len);

                expr.append("-").append(part);
                backtrack(num, target, i + 1, eval - val, -val, expr);
                expr.setLength(len);

                expr.append("*").append(part);
                backtrack(num, target, i + 1, eval - prev + prev * val, prev * val, expr);
                expr.setLength(len);
            }
        }
    }
}
