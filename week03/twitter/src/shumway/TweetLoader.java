package shumway;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
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
        .setOAuthConsumerKey("PUT YOUR CONSUMER KEY HERE")
        .setOAuthConsumerSecret("PUT YOUR CONSUMER SECRET HERE")
        .setOAuthAccessToken("PUT YOUR ACCESS TOKEN HERE")
        .setOAuthAccessTokenSecret("PUT YOUR ACCESS TOKEN SECRET HERE")
        .setJSONStoreEnabled(true);

    TwitterFactory tf = new TwitterFactory(cb.build());
    this.twitter = tf.getInstance();
  }

  public Map<String,BYUITweet> retrieveTweetsWithHashTag(String hashtag) {
    //for hashmap example
    //http://tutorialswithexamples.com/java-map-and-hashmap-tutorial-with-examples/
    HashMap<String,BYUITweet> ht = new HashMap<String,BYUITweet>();
    BYUITweet tweet = new BYUITweet();
    Gson gson = new Gson();


    //Query, QueryResult, and Status came from this site
    //http://twitter4j.org/en/code-examples.html
    Query query = new Query(hashtag);
    try {
      QueryResult result = twitter.search(query);
      for (Status status : result.getTweets()) {



        //TODO: need to understand out to deserialize tweet results
        //TODO: take the JSON output and assign it to the map

      }
    } catch (TwitterException e) {
      e.printStackTrace();
    }



    //TODO: doublecheck this function - but need to return a MAP
    return null;
  }
}
