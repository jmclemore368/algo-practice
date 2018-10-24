class Solution {
    public String convertToTitle(int n) {
      // Take off the last number by subtracting by its value
      // Then "remove" a column by divide by 26
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int lastNum = (n % 26) == 0 ? 26 : (n % 26);
            char lastAscii = (char) (64 + lastNum);
            sb.append(lastAscii);
            n = (n - lastNum) / 26;
        }
        return sb.reverse().toString();
    }
}
