public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of stairs must not be negative");
        }
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 1;
        int twoStepsBefore = 2;
        for (int stair = 3; stair <= n; stair++) {
            int currentWays = Math.addExact(oneStepBefore, twoStepsBefore);
            oneStepBefore = twoStepsBefore;
            twoStepsBefore = currentWays;
        }
        return twoStepsBefore;
    }
}
