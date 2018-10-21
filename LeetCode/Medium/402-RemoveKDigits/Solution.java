class Solution {
    public String removeKdigits(String num, int k) {

        // Edge case: Remove all characters, return 0.
        if (num.length() == k)
            return "0";

        // Trick: For each num at i, remove i-1 if i-1 > i
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            Character curr = num.charAt(i);
            while (!stack.isEmpty() && stack.peekFirst() > curr && k-- > 0)
                stack.removeFirst();
            stack.addFirst(curr);
        }

        // Edge case: if K > 0 then we did not remove any as
        // the largest were all at the end.
        // Ex] 1111, 112
        while (k-- > 0)
            stack.removeFirst();

        // Make into string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.removeFirst());
        sb.reverse();

        // Edge case: Remove all leading 0
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
