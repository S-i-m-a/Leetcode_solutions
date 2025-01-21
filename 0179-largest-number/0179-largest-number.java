import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integers to strings to compare them more easily
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array of strings with a custom comparator
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare concatenated strings to determine order
                return (b + a).compareTo(a + b);
            }
        });

        // If the largest number is "0", we return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (String num : strNums) {
            largestNum.append(num);
        }

        return largestNum.toString();
    }
}
