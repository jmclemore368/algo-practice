class Solution {
    public String convertToTitle(int n) {
      // Take off the last number by subtracting by its value
      // Then "remove" a column by divide by 26
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // Subtract 1 so A maps to 0 in Mod and Z maps to 25
            int lastNum = (n - 1) % 26;
            char lastAscii = (char) (65 + lastNum);
            sb.append(lastAscii);
            n = (n - lastNum) / 26;
        }
        return sb.reverse().toString();
    }
}
