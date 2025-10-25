class Solution {
    public int totalMoney(int n) {
        int completeWeeks = n / 7;
        int remainingDays = n % 7;

        // Sum for all complete weeks:
        // Week 1 sum = 1+2+3+4+5+6+7 = 28
        // Week 2 sum = 2+3+4+5+6+7+8 = 35 = 28 + 7
        // ...
        int firstWeekSum = 28;
        int lastWeekSum = 28 + 7 * (completeWeeks - 1);
        int totalCompleteWeeks = (firstWeekSum + lastWeekSum) * completeWeeks / 2;

        // Sum for the remaining days after the complete weeks:
        // On the (completeWeeks+1)-th week, Monday deposit = completeWeeks + 1
        int firstDay = completeWeeks + 1;
        int lastDay = completeWeeks + remainingDays;
        int totalRemaining = (firstDay + lastDay) * remainingDays / 2;

        return totalCompleteWeeks + totalRemaining;
    }
}
