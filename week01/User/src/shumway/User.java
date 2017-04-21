package shumway;

import javax.print.DocFlavor;

/**
 * Created by thesh on 4/20/2017.
 */
public class User {

    private String uPassword;
    private String uSalt;
    private String uHash;

    public String getPassword() {
        return uPassword;
    }

    public void setPassword(String thePassword) {
        uPassword = thePassword;
    }

    public String getSalt() {
        return uSalt;
    }

    public void setSalt(String theSalt) {
        uSalt = theSalt;
    }

    public String getHashedPassword() {
        return uHash;
    }

    public void setHashedPassword(String theHash) {
        uHash = theHash;
    }

    public User(String password) {
        uPassword = password;
    }
}
