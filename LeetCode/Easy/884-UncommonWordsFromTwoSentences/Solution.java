class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String S : (A + " " + B).split(" "))
            wordCounts.put(S, wordCounts.getOrDefault(S, 0) + 1);

        List<String> res = new LinkedList<>();
        for (String K : wordCounts.keySet())
            if (wordCounts.get(K) == 1)
                res.add(K);
        return res.toArray(new String[0]);
    }
}
