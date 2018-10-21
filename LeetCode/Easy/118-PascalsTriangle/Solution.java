class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Construct the triangle using 2d array
        List<List<Integer>> pt = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            pt.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                pt.get(i).add(((j == 0) || (j == i)) ?
                              1 : pt.get(i-1).get(j-1) + pt.get(i-1).get(j));
            }
        }
        return pt;
    }
}
