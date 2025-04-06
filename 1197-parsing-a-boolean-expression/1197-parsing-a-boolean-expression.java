class Solution {
    public boolean parseBoolExpr(String expression) {
        return eval(expression);
    }

    private boolean eval(String expr) {
        if (expr.equals("t")) return true;
        if (expr.equals("f")) return false;

        char op = expr.charAt(0);
        String content = expr.substring(2, expr.length() - 1);

        List<Boolean> values = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == ',' && balance == 0) {
                values.add(eval(content.substring(start, i)));
                start = i + 1;
            } else if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
        }

        // Add last expression
        values.add(eval(content.substring(start)));

        if (op == '!') {
            return !values.get(0);
        } else if (op == '&') {
            for (boolean val : values) {
                if (!val) return false;
            }
            return true;
        } else { // op == '|'
            for (boolean val : values) {
                if (val) return true;
            }
            return false;
        }
    }
}
