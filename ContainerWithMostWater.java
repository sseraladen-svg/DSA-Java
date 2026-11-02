public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int left = 0;
        int right = height.length - 1;
        long maximumArea = 0;
        while (left < right) {
            if (height[left] < 0 || height[right] < 0) {
                throw new IllegalArgumentException("Heights must not be negative");
            }

            long area = (long) Math.min(height[left], height[right]) * (right - left);
            maximumArea = Math.max(maximumArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return Math.toIntExact(maximumArea);
    }
}
