class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            Long first = Long.valueOf(num.substring(0, i));
            for (int j = 1; num.length() - i - j > 0; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                Long second = Long.valueOf(num.substring(i, i + j));
                if (isValid(first, second, num, i + j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(Long first, Long second, String arr, int index) {
        if (index == arr.length()) {
            return true;
        }
        Long third = first + second;
        first = second;
        second = third;
        String sum = Long.toString(second);
        return arr.startsWith(sum, index) && isValid(first, second, arr, index + sum.length());
    }
}