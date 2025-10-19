import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        String smallest = s;
        int n = s.length();

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: add 'a' to all digits at odd indices
            char[] chars = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int digit = (chars[i] - '0' + a) % 10;
                chars[i] = (char) ('0' + digit);
            }
            String added = new String(chars);

            if (visited.add(added)) {
                queue.offer(added);
            }

            // Operation 2: rotate right by b positions
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return smallest;
    }
}
