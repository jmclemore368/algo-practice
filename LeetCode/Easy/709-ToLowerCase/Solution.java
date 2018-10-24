class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 65 && ch <= 90)
                ch += 32; // Refer to ASCII table
            sb.append(ch);
        }
        return sb.toString();
    }
}
