package shumway;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thesh on 5/2/2017.
 */
public class BYUITweet {
  User user;

  @SerializedName("text")
  public String text;

  public User getUser() { return user; }

  public void setUser(User myUser) {
    user = myUser;
  }

  public String getText() { return text; }

  public void setText(String tweet) {
    text = tweet;
  }

}
