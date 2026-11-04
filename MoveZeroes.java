public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int nextNonZero = 0;
        for (int value : nums) {
            if (value != 0) {
                nums[nextNonZero++] = value;
            }
        }
        while (nextNonZero < nums.length) {
            nums[nextNonZero++] = 0;
        }
    }
}
