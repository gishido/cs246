package shumway;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by thesh on 5/2/2017.
 */
public class TweetLoader {

  Twitter twitter;

  public TweetLoader() {
    configureKeys();
  }

  private void configureKeys() {
    ConfigurationBuilder cb = new ConfigurationBuilder();

    cb.setDebugEnabled(true)
        .setOAuthConsumerKey("JFq9JE3m6UWnzlDJgMr3Goono")
        .setOAuthConsumerSecret("kMpROMC9YzbJrbT2vGwJTg9hqlJXVHzv6znMerxyPAk1tWd5wF")
        .setOAuthAccessToken("213183992-WgVaBbpyq6fcmS9PJFgnmoh66pqnqYg4zXKsHGCA")
        .setOAuthAccessTokenSecret("28r0ul8sDSksjbB0RBeG6BXH6Fp3xlvillTzoWnyLNnzh")
        .setJSONStoreEnabled(true);

    TwitterFactory tf = new TwitterFactory(cb.build());
    twitter = tf.getInstance();
  }

  public Map<String,BYUITweet> retrieveTweetsWithHashTag(String hashtag) {
    //for hashmap example
    //http://tutorialswithexamples.com/java-map-and-hashmap-tutorial-with-examples/
    Map<String,BYUITweet> ht = new HashMap<>();

    //Query, QueryResult, and Status came from this site
    //http://twitter4j.org/en/code-examples.html
    //Twitter twitter = TwitterFactory.getSingleton();
    Query query = new Query(hashtag);
    QueryResult result;

    try {
      result = twitter.search(query);
      } catch (TwitterException e) {
      e.printStackTrace();
      return null;
    }

    for(Status status : result.getTweets()) {
      String json = TwitterObjectFactory.getRawJSON(status);

      Gson gson = new Gson();
      BYUITweet bt = gson.fromJson(json, BYUITweet.class);

      ht.put(bt.user.name, bt);
    }



    return ht;
  }
}
