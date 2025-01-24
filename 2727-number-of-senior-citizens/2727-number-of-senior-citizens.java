class Solution {
    // Method to count the number of seniors based on their age details.
    public int countSeniors(String[] details) {
        // Initialize a counter for seniors.
        int seniorCount = 0;
      
        // Loop through all the provided age details.
        for (String detail : details) {
            // Extract the age from the current detail string.
            // Assuming the age is always in the same position (index 11 to 13).
            int age = Integer.parseInt(detail.substring(11, 13));
          
            // Check if the age is greater than 60 to determine if the person is a senior.
            if (age > 60) {
                // Increment the count for seniors.
                seniorCount++;
            }
        }
      
        // Return the final count of seniors.
        return seniorCount;
    }
}