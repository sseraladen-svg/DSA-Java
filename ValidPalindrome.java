public class ValidPalindrome {
    public boolean isPalindrome(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        int left = 0;
        int right = value.length();
        while (left < right) {
            int leftCodePoint = value.codePointAt(left);
            if (!Character.isLetterOrDigit(leftCodePoint)) {
                left += Character.charCount(leftCodePoint);
                continue;
            }

            int rightCodePoint = value.codePointBefore(right);
            if (!Character.isLetterOrDigit(rightCodePoint)) {
                right -= Character.charCount(rightCodePoint);
                continue;
            }

            if (Character.toLowerCase(leftCodePoint) != Character.toLowerCase(rightCodePoint)) {
                return false;
            }
            left += Character.charCount(leftCodePoint);
            right -= Character.charCount(rightCodePoint);
        }
        return true;
    }
}
