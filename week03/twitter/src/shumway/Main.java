package shumway;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
      TweetLoader newLoad = new TweetLoader();

      Map<String, BYUITweet> tweets = newLoad.retrieveTweetsWithHashTag("#byui");

      for (String name : tweets.keySet()) {
        BYUITweet myTweet = tweets.get(name);
        System.out.println(String.format("%s (%d followers): %s",
            name, myTweet.getUser().getFollowers(), myTweet.getText()));
      }

      List<String> sortNames = new ArrayList<>(tweets.keySet());

      Collections.sort(sortNames, (o1, o2) -> Integer.compare(tweets.get(o2).getUser().getFollowers(),
          tweets.get(o1).getUser().getFollowers())
      );


      for(String name : sortNames) {
        BYUITweet myTweet = tweets.get(name);
        System.out.println(String.format("%s (%d folloers): %s", name, myTweet.getUser().getFollowers(), myTweet.getText()));
      }

    }
}
