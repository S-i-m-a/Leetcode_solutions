import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Use a max-heap to always pick the two heaviest stones
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Repeatedly smash the two heaviest stones
        while (pq.size() > 1) {
            int y = pq.poll(); // heaviest
            int x = pq.poll(); // second heaviest
            if (y != x) {
                pq.offer(y - x);
            }
            // if y == x, both are destroyed (do nothing)
        }

        // Return the weight of the remaining stone, or 0 if none
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
