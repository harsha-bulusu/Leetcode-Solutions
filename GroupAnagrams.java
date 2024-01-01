class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (freqMap.containsKey(sortedString)) {
                freqMap.get(sortedString).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                freqMap.put(sortedString, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (java.util.Map.Entry<String, List<String>> entry : freqMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;


    }
}
