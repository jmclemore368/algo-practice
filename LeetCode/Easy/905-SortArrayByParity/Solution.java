class Solution {
    public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length;
        while (even < odd) {
            if (A[even] % 2 != 0) {
                odd -= 1;
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            } else {
                even++;
            }
        }
        return A;
    }
}
