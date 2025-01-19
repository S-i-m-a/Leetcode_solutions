import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both the players and trainers arrays
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int playerIndex = 0;
        int trainerIndex = 0;
        int matches = 0;
        
        // Use two pointers to match players with trainers
        while (playerIndex < players.length && trainerIndex < trainers.length) {
            if (trainers[trainerIndex] >= players[playerIndex]) {
                // Match the player with the current trainer
                matches++;
                playerIndex++;
            }
            // Move to the next trainer regardless of whether a match is made
            trainerIndex++;
        }
        
        return matches;
    }
}
