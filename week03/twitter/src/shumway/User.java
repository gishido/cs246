package shumway;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thesh on 5/2/2017.
 */
public class User {
  @SerializedName("screen_name")
  public String name;

  @SerializedName("followers_count")
  public int followers;

  public String getName() { return name; }

  public void setName(String value) {
    name = value;
  }

  public int getFollowers() { return followers; }

  public void setFollowers(int num) {
    followers = num;
  }
}
