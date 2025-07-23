class Solution {
    public int maximumGain(String s, int x, int y) {
        // Always remove the higher-value substring first: "ab" vs "ba"
        if (y > x) {
            return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
        }

        int score = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                stack.pop();
                score += x;
            } else {
                stack.push(c);
            }
        }

        Deque<Character> remaining = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (!remaining.isEmpty() && remaining.peek() == 'a' && c == 'b') {
                remaining.pop();
                score += y;
            } else {
                remaining.push(c);
            }
        }

        return score;
    }
}
