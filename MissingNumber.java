public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
