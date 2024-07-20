package java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {
    // follow관계를 떠나서 자기가 올린글을 feed에서 볼 수 있는데, 시간순 정렬이 필요하다.
    class Tweet {
        Long time;
        int tweetId;
    }

    Map<Integer, List<Tweet>> user_feed = new HashMap<>();
    Map<Integer, Set<Integer>> user_follow = new HashMap<>();

    public boolean postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet();
        tweet.time = System.currentTimeMillis();
        tweet.tweetId = tweetId;

        List<Tweet> feed = null;
        if (user_feed.containsKey(userId) == false) {
            feed = new ArrayList<>();
        } else {
            feed = user_feed.get(userId);
        }
        feed.add(tweet);
        user_feed.put(userId, feed);
        return true;
    }

    public List<Integer> getNewsFeed(int userId) {
        // my_feed는 new로 복사본 만들어서 작업해야함에 유의. 안그러면 map안의 내용도 변경돼버린다.
        List<Tweet> my_feed = new ArrayList<>(user_feed.getOrDefault(userId, new ArrayList<>()));

        Set<Integer> followers = user_follow.getOrDefault(userId, new HashSet<>());
        for (int followerId : followers) {
            my_feed.addAll(user_feed.getOrDefault(followerId, new ArrayList<>()));
        }
        my_feed.sort((t1, t2) -> t2.time.compareTo(t1.time));

        List<Integer> total_feeds = new ArrayList<>();
        for (Tweet t : my_feed)
            total_feeds.add(t.tweetId);
        return total_feeds;
        //return my_feed.stream().map(t -> t.tweetId).collect(Collectors.toList());

    }

    public boolean follow(int followerId, int followeeId) {
        Set<Integer> followers = user_follow.getOrDefault(followerId, new HashSet<>());
        if (followers.contains(followeeId))
            return false;
        followers.add(followeeId);
        user_follow.put(followerId,followers);  // 위에서 new된 경우를 위한 코드
        return true;
    }

    public boolean unfollow(int followerId, int followeeId) {

        if (user_follow.containsKey(followerId) == false)
            return false;
        Set<Integer> followers = user_follow.get(followerId);
        followers.remove((Integer) followeeId);
        user_follow.put(followerId,followers);
        return true;
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        // 사용자 1이 새 트윗(id=5)을 게시합니다.
        System.out.println(twitter.postTweet(1, 5));

        // 사용자 1의 뉴스 피드는 1개의 트윗 아이디 [5]를 반환해야 합니다.
        System.out.println(twitter.getNewsFeed(1));

        // 사용자 1이 사용자 2를 팔로우합니다.
        System.out.println(twitter.follow(1, 2));

        // 사용자 2가 새 트윗(id=6)을 게시합니다.
        System.out.println(twitter.postTweet(2, 6));

        // 사용자 1의 뉴스 피드는 2개의 트윗 아이디 [6,5]를 반환해야 합니다.
        // 트윗 아이디 6이 트윗 아이디 5보다 먼저 와야 합니다. 왜냐하면 트윗 아이디 5가 게시된 후에 게시되었기 때문입니다.
        System.out.println(twitter.getNewsFeed(1));

        // 사용자 1이 사용자 2를 언팔로우합니다.
        System.out.println(twitter.unfollow(1, 2));

        // 사용자 1의 뉴스 피드는 1개의 트윗 아이디 [5]를 반환해야 합니다.
        // 사용자 1이 더 이상 사용자 2를 팔로우하지 않기 때문입니다.
        System.out.println(twitter.getNewsFeed(1));
    }
}
