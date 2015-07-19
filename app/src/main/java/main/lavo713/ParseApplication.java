package main.lavo713;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Lotan on 7/14/2015.
 */
public class ParseApplication extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add your initialization code here
        Parse.initialize(this, "howoPxDk45oOAjw9hFzFqtbmBwYeYuHNlTgkV1IN", "HjWYmxK9w1bJ8KTFtzUPZpuZBCO2RhEcdFvVAeZK");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
