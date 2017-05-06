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
    Map<String,BYUITweet> ht = new HashMap<String,BYUITweet>();
    User user = new User();
    BYUITweet tweet = new BYUITweet();
    Gson gson = new Gson();
    String jsonTweet;
    int count = 0;


    //Query, QueryResult, and Status came from this site
    //http://twitter4j.org/en/code-examples.html
    //Twitter twitter = TwitterFactory.getSingleton();
    Query query = new Query(hashtag);
    try {
      QueryResult result = twitter.search(query);
      List<Status> tweets = result.getTweets();
      //TODO: need to understand out to deserialize tweet results
//TODO: take the JSON output and assign it to the map
      for (Status status : tweets) {
        System.out.println("@" + status.getUser().getScreenName() + " - " + "followers: " + status.getUser().getFollowersCount());
        count++;
        jsonTweet = TwitterObjectFactory.getRawJSON(status);

       /* System.out.println("From JSON: " + jsonTweet);*/
        user = gson.fromJson(jsonTweet, User.class);

        tweet = gson.fromJson(jsonTweet, BYUITweet.class);

/*        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tweetData.json"), StandardCharsets.UTF_8))) {
          writer.write(jsonTweet);
        }
        catch (IOException ex) {
          // Handle me
        }*/

        System.out.println("User name: " + user.getName() + " followers: " + user.getFollowers());

        //tweet.setUser(user);
        //tweet.setText(TwitterObjectFactory.getRawJSON(status.getText()));

       /* System.out.println("TwitterUser: " + tweet.getUser().getName() + " TwitterText: " + tweet.getText());*/

        ht.put(tweet.getUser().getName(), tweet);

        System.out.println(count + " iterations");

      }
    } catch (TwitterException e) {
      e.printStackTrace();
    }



    //TODO: doublecheck this function - but need to return a MAP
    return ht;
  }
}
