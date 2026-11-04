public class NumberOfOneBits {
    public int hammingWeight(int value) {
        int count = 0;
        while (value != 0) {
            value &= value - 1;
            count++;
        }
        return count;
    }
}
