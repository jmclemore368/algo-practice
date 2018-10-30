public class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s.trim());
        // Reverse the entire string
        sb.reverse();

        // Order of words is correct
        // Individual words need reversing now
        // Ex] eulb si yks eht
        System.out.println("Word : " + sb.toString());
        int start = 0;
        int end;
        while ((end = sb.indexOf(" ", start)) != -1) {
            // Replace this individual word
            String word = new StringBuilder(sb.substring(start, end)).reverse().toString();
            sb.replace(start, end, word);

            // Advance to next word
            start = end;
            while (sb.charAt(start) == ' ') start++;

            // There should not be more than 1 space between words
            int spacesToDelete = start - end - 1;
            while (spacesToDelete-- > 0) sb.deleteCharAt(end);
            start = end + 1;
        }

        // While loop breaks before last word
        end = sb.length();
        String lastWord = new StringBuilder(sb.substring(start, end)).reverse().toString();
        sb.replace(start, sb.length(), lastWord);

        return sb.toString();
    }
}
