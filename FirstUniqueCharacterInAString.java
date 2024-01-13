class Solution {
    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.add(ch)) {
                list.add(ch);
                map.put(ch, i);
            } else {
                list.remove(Character.valueOf(ch));
            }
        }

        return list.size() == 0 ? - 1 : map.get(list.get(0));
    }
}
