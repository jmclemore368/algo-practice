class Solution {
    public String removeKdigits(String num, int k) {
        // Edge case: Remove all characters, return 0.
        if (num.length() == k)
            return "0";

        // Trick: For each num at i, remove i-1 if i-1 > i
        Deque<Character> stack = new LinkedList<>();
        stack.addFirst(num.charAt(0));

        for (int i = 1; i < num.length(); i++) {
            Character curr = num.charAt(i);
            Character previous = stack.peekFirst();
            while (!stack.isEmpty() && previous != null && previous > curr && k > 0) {
                stack.removeFirst();
                k--;
                previous = stack.peekFirst();
            }
            stack.addFirst(curr);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.removeFirst());


        // Find the first nonzero entry
        String result = sb.reverse().toString();
        int start = 0;
        while (start < result.length() && result.charAt(start) == '0')
            start++;

        // Edge case: If multiple 0 such as 000, return 0.
        if (start == result.length())
            return "0";

        // Edge case, if K > 0 then we did not remove any.
        // Example: All are the same. Such as 1111.
        // Example: Last is/are the greatest. Such as 112.
        // Either way, remove from the end.
        return result.substring(start, result.length() - k);
    }
}
