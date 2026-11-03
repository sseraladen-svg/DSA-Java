public class CountingBits {
    public int[] countBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Upper bound must not be negative");
        }

        int[] counts = new int[n + 1];
        for (int value = 1; value <= n; value++) {
            counts[value] = counts[value >>> 1] + (value & 1);
        }
        return counts;
    }
}
