class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Map which stores player and respective player losses
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int looser = matches[i][1];
            // loading players if they doesn't exist in the map
            if (!map.containsKey(winner)) {
                map.put(winner, 0);
            }
            if (!map.containsKey(looser)) {
                map.put(looser, 0);
            }

            map.put(looser, map.get(looser) + 1); 
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res0 = new ArrayList<>(); //player with all wins
        List<Integer> res1 = new ArrayList<>(); //player with exactly one loss
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int losses = entry.getValue();
            int player = entry.getKey();
            if (losses == 0) {
                res0.add(player);
            } else if(losses == 1){
                res1.add(player);
            }
        }
        Collections.sort(res0);
        Collections.sort(res1);
        res.add(res0);
        res.add(res1);
        return res;
    }
}
