// following tracks followee-follower link
// tweets tracks tweets, head is most recent, tail is least
class Twitter {

    private record Tweet(int userId, int tweetId) {}

    LinkedList<Tweet> tweets;
    HashMap<Integer, HashSet<Integer>> following;

    public Twitter() {
        tweets = new LinkedList<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.addFirst(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> feed = new ArrayList<>();
        HashSet<Integer> follows = following.getOrDefault(userId, null);
        for (Tweet tweet : tweets) {
            int id = tweet.userId();
            if (id == userId || (follows != null && follows.contains(id))) {
                feed.add(tweet.tweetId());
            }
            if (feed.size() == 10) {
                return feed;
            }
        }            
        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) return;
        following.get(followerId).remove(followeeId);
    }
}
