class Solution {
    private String startCombination; // Start combination for the lock
    private String targetCombination; // Target combination to unlock
    private Set<String> deadEnds = new HashSet<>(); // Set to store deadends

    // Method to find the minimum number of moves to open the lock
    public int openLock(String[] deadends, String target) {
        startCombination = "0000";
        this.targetCombination = target;

        // Add all deadends to the set
        Collections.addAll(this.deadEnds, deadends);
      
        // If the starting point is a deadend, we cannot proceed
        if (this.deadEnds.contains(startCombination)) {
            return -1;
        }
      
        // If target is startCombination return 0 as no steps required
        if (target.equals(startCombination)) {
            return 0;
        }

        // Use bidirectional BFS to find the shortest path
        return bidirectionalBfs();
    }

    // Helper method to perform bidirectional BFS search on the lock combinations
    private int bidirectionalBfs() {
        Map<String, Integer> visitedFromStart = new HashMap<>(); // Record steps from start
        Map<String, Integer> visitedFromTarget = new HashMap<>(); // Record steps from target
        Deque<String> queueFromStart = new ArrayDeque<>(); // Queue for BFS from start
        Deque<String> queueFromTarget = new ArrayDeque<>(); // Queue for BFS from target

        // Initialize the BFS from both ends
        visitedFromStart.put(startCombination, 0);
        visitedFromTarget.put(targetCombination, 0);
        queueFromStart.offer(startCombination);
        queueFromTarget.offer(targetCombination);

        while (!queueFromStart.isEmpty() && !queueFromTarget.isEmpty()) {
            // Always extend the smaller queue to optimize performance
            int turns = queueFromStart.size() <= queueFromTarget.size() ?
                        extendQueue(visitedFromStart, visitedFromTarget, queueFromStart) :
                        extendQueue(visitedFromTarget, visitedFromStart, queueFromTarget);
          
            // If turns not equals to -1, a solution has been found
            if (turns != -1) {
                return turns;
            }
        }
        return -1; // If no solution is found
    }

    // Expand the current level of the BFS search and check for intersections
    private int extendQueue(Map<String, Integer> currentVisited, Map<String, Integer> oppositeVisited, Deque<String> currentQueue) {
        int currentSize = currentQueue.size();
        for (int i = 0; i < currentSize; ++i) {
            String currentCombination = currentQueue.poll();
            int currentStepCount = currentVisited.get(currentCombination);
          
            // Evaluate next possible combinations
            for (String nextCombination : getNextCombinations(currentCombination)) {
                // Skip if visited or is a dead end
                if (currentVisited.containsKey(nextCombination) || deadEnds.contains(nextCombination)) {
                    continue;
                }

                // If this combination has been reached from the opposite direction, return the total move count
                if (oppositeVisited.containsKey(nextCombination)) {
                    return currentStepCount + 1 + oppositeVisited.get(nextCombination);
                }
              
                // Record the step count and add the new combination to the queue
                currentVisited.put(nextCombination, currentStepCount + 1);
                currentQueue.offer(nextCombination);
            }
        }
        return -1;
    }

    // Generate all next possible lock combinations from a given combination
    private List<String> getNextCombinations(String combination) {
        List<String> nextCombinations = new ArrayList<>();
        char[] chars = combination.toCharArray();
      
        for (int i = 0; i < 4; ++i) {
            char originalChar = chars[i];
          
            // Turn the wheel one step forward
            chars[i] = originalChar == '9' ? '0' : (char) (originalChar + 1);
            nextCombinations.add(new String(chars));
          
            // Turn the wheel one step backwards
            chars[i] = originalChar == '0' ? '9' : (char) (originalChar - 1);
            nextCombinations.add(new String(chars));
          
            // Restore the original state for the next iteration
            chars[i] = originalChar;
        }
      
        return nextCombinations;
    }
}