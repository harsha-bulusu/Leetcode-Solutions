class Solution {
    public int findJudge(int n, int[][] trust) {
        List<Set<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new HashSet());
        }

        for (int i = 0;  i < trust.length; i++) {
            int u = trust[i][0];
            int v = trust[i][1];
            adj.get(u).add(v);
        }

        int townJudge = -1;

        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == 0) {
                townJudge = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i != townJudge && adj.get(i).add(townJudge)) {
                return -1;
            }
        }

        return townJudge;
    }
}
