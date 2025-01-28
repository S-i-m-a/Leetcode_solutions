import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Map to count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Priority Queue (Min-Heap) to store the top K frequent words
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (w1, w2) -> frequencyMap.get(w1).equals(frequencyMap.get(w2))
                        ? w2.compareTo(w1) // If frequencies are equal, sort alphabetically in reverse
                        : frequencyMap.get(w1) - frequencyMap.get(w2) // Otherwise, sort by frequency
        );

        // Add words to the heap
        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the word with the lowest frequency (or lexicographically largest)
            }
        }

        // Prepare the result by extracting from the heap
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Since the heap is a min-heap, the order needs to be reversed
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println("Top K Frequent Words: " + solution.topKFrequent(words, k));
    }
}
