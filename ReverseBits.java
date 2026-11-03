public class ReverseBits {
    public int reverseBits(int value) {
        int reversed = 0;
        for (int bit = 0; bit < Integer.SIZE; bit++) {
            reversed = (reversed << 1) | (value & 1);
            value >>>= 1;
        }
        return reversed;
    }
}
