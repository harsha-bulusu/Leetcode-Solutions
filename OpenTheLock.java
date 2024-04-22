class Pair {
    String val;
    int cnt;

    public Pair(String val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}

class Solution {

    private List<String> transform(String val) {
        List<String> transformedLocks = new ArrayList<>();
            for (int i = 0; i <= 3; i++) {
                
                String prefix = val.substring(0, i);
                String tar = val.substring(i, i + 1);
                String suffix = val.substring(i + 1, 4);
                int forwardValue = (Integer.parseInt(tar) + 1) % 10;
                int backwardValue = (Integer.parseInt(tar) - 1 + 10) % 10;

                String onForward = prefix + String.valueOf(forwardValue) + suffix;
                String onBackward = prefix + String.valueOf(backwardValue) + suffix;

                transformedLocks.add(onForward);
                transformedLocks.add(onBackward);
                
            }

        return transformedLocks;
    }

    public int openLock(String[] deadends, String target) {

        Set<String> invalidLocks = new HashSet<>();
        for (String str : deadends) {
            invalidLocks.add(str);
        }
        

        String init = new String("0000");
        if (invalidLocks.contains(init)) return -1;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(init, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String val = pair.val;
            int cnt = pair.cnt;

            if (val.equals(target)) return cnt;

            // apply transformations
            List<String> transformedLocks = transform(val);

            for (String transformedLock : transformedLocks) {
                if (!invalidLocks.contains(transformedLock)) {
                    queue.add(new Pair(transformedLock, cnt + 1));
                    invalidLocks.add(transformedLock);
                }
            }
        }


        return -1;
    }
}
