class Solution {
    public int numJewelsInStones(String J, String S) {
        // Can use Hash Set, bool array faster
        boolean[] a = new boolean[128];
        for (int i = 0; i < J.length(); i++) {
            a[J.charAt(i)] = true;
        }

        int count = 0;
        for (int k = 0; k < S.length(); k++) {
            if (a[S.charAt(k)]) count++;
        }

        return count;

    }
}
