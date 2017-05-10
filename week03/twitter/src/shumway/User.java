package shumway;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thesh on 5/2/2017.
 */
public class User {

  String name;

  @SerializedName("followers_count")
  int followers;

  public String getName() { return name; }

  public void setName(String value) {
    name = value;
  }

  public int getFollowers() { return followers; }

  public void setFollowers(int num) {
    followers = num;
  }
}
