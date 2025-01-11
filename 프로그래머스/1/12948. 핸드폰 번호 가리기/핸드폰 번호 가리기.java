class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public String solution(String phone_number) {
        int length = phone_number.length();
        String substring = phone_number.substring(phone_number.length() - 4, phone_number.length());
        return "*".repeat(length - 4) + substring;
    }

}
