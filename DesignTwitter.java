class Pair {
    int tweet;
    int time;

    public Pair(int tweet, int time) {
        this.tweet = tweet;
        this.time = time;
    }
}

class TweetInfo {
    int time;
    int followerId;
    int index;
    int tweet;

    public TweetInfo(int time, int followerId, int index, int tweet) {
        this.time = time;
        this.followerId = followerId;
        this.index = index;
        this.tweet = tweet;
    }
}

public class Twitter {

    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<Pair>> tweets;
    int time;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!followers.containsKey(userId)) {
            followers.put(userId, getDefaultFollowers(userId));
        }
        List<Pair> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        userTweets.add(new Pair(tweetId, ++time));
        tweets.put(userId, userTweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetInfo> maxHeap = new PriorityQueue<>((p1, p2) -> p2.time - p1.time);
        loadTweets(maxHeap, userId);
        List<Integer> posts = new ArrayList<>();        
        
        while(!maxHeap.isEmpty() && posts.size() < 10) {
            TweetInfo tweetInfo = maxHeap.poll();
            posts.add(tweetInfo.tweet);
            if (tweetInfo.index > 0) {
                int followerId = tweetInfo.followerId;
                Pair tweet = tweets.get(followerId).get(tweetInfo.index - 1);
                maxHeap.add(new TweetInfo(tweet.time, followerId, tweetInfo.index - 1, tweet.tweet));
            }
        }
        return posts;
    }

    private void loadTweets(PriorityQueue<TweetInfo> maxHeap, int userId) {
        if (!followers.containsKey(userId)) return;
        for (int followee : followers.get(userId)) {
            if (tweets.containsKey(followee)) {
                int tweetsCount = tweets.get(followee).size();
                if (tweetsCount > 0) {
                    Pair tweet = tweets.get(followee).get(tweetsCount - 1);
                    maxHeap.add(new TweetInfo(tweet.time, followee, tweetsCount - 1, tweet.tweet));
                } 
            }
        }
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followee = followers.getOrDefault(followerId, this.getDefaultFollowers(followerId));
        followee.add(followeeId);
        followers.put(followerId, followee);
    }

    private Set<Integer> getDefaultFollowers(int followerId) {
        Set<Integer> defaultFollowers = new HashSet<>();
        defaultFollowers.add(followerId);
        return defaultFollowers;
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followee = followers.get(followerId);
        followee.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
