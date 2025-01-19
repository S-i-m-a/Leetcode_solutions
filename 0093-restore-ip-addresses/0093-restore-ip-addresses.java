class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result; // If the length is less than 4 or more than 12, no valid IP is possible
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 parts and we've used the entire string, it's a valid IP
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try all possible lengths of the next part (1, 2, or 3 digits)
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break; // Avoid index out of bounds
            String part = s.substring(start, start + len);
            // Check if the part is valid (should not have leading zeros unless it is "0")
            if (isValid(part)) {
                current.add(part); // Add part to current list
                backtrack(s, start + len, current, result); // Recurse to find the next part
                current.remove(current.size() - 1); // Backtrack to try other possibilities
            }
        }
    }

    // Helper function to check if the part is valid
    private boolean isValid(String part) {
        // A valid part is between "0" and "255" and has no leading zeros unless it is "0"
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}
