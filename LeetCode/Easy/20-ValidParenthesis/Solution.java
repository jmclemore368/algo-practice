class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next == '(' || next == '[' || next == '{') {
                q.addFirst(next);
            } else {
                if (q.isEmpty()) {
                    return false;
                }
                char last = q.removeFirst();
                if (   (next == ')' && last != '(')
                    || (next == ']' && last != '[')
                    || (next == '}' && last != '{')) {
                    return false;
                }
            }
        }
        return q.isEmpty();
    }
}
