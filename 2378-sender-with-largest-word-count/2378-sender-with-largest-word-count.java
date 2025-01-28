import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Calculate word count for each sender
        for (int i = 0; i < messages.length; i++) {
            String message = messages[i];
            String sender = senders[i];
            
            // Count the number of words in the message
            int wordCount = message.split(" ").length;

            // Add the word count to the sender's total
            wordCountMap.put(sender, wordCountMap.getOrDefault(sender, 0) + wordCount);
        }

        String topSender = "";
        int maxWordCount = 0;

        // Find the sender with the largest word count
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String sender = entry.getKey();
            int wordCount = entry.getValue();

            // Check for the largest word count or lexicographical order in case of a tie
            if (wordCount > maxWordCount || (wordCount == maxWordCount && sender.compareTo(topSender) > 0)) {
                topSender = sender;
                maxWordCount = wordCount;
            }
        }

        return topSender;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        String[] messages = {"Hello world", "How are you", "I am fine"};
        String[] senders = {"Alice", "Bob", "Alice"};
        System.out.println("Sender with Largest Word Count: " + solution.largestWordCount(messages, senders));
    }
}
